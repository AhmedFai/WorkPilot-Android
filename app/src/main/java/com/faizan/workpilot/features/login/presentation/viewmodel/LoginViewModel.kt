package com.faizan.workpilot.features.login.presentation.viewmodel

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.core.network.error.NetworkErrorHandler
import com.faizan.workpilot.features.login.domain.model.LoginRequest
import com.faizan.workpilot.features.login.domain.usecase.GetLoginSessionUseCase
import com.faizan.workpilot.features.login.domain.usecase.LoginUseCase
import com.faizan.workpilot.features.login.domain.usecase.SaveLoginSessionUseCase
import com.faizan.workpilot.features.login.presentation.model.LoginUiEvent
import com.faizan.workpilot.features.login.presentation.model.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val saveLoginSessionUseCase: SaveLoginSessionUseCase,
    private val getLoginSessionUseCase: GetLoginSessionUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        LoginUiState()
    )

    val uiState: StateFlow<LoginUiState> =
        _uiState.asStateFlow()

    private val _uiEvent =
        MutableSharedFlow<LoginUiEvent>()

    val uiEvent: SharedFlow<LoginUiEvent> =
        _uiEvent.asSharedFlow()

    fun onEmailChanged(email: String) {
        _uiState.update {
            it.copy(
                email = email,
                emailError = null,
                generalError = null
            )
        }
    }

    fun onPasswordChanged(password: String) {
        _uiState.update {
            it.copy(
                password = password,
                passwordError = null,
                generalError = null
            )
        }
    }

    fun onPasswordVisibilityChanged() {
        _uiState.update {
            it.copy(
                isPasswordVisible = !it.isPasswordVisible
            )
        }
    }

    fun login() {

        if (_uiState.value.isLoading) {
            return
        }

        val currentState = _uiState.value

        val emailError = validateEmail(
            currentState.email
        )

        val passwordError = validatePassword(
            currentState.password
        )

        if (emailError != null || passwordError != null) {
            _uiState.update {
                it.copy(
                    emailError = emailError,
                    passwordError = passwordError
                )
            }
            return
        }

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true,
                    generalError = null
                )
            }

            try {

                val result = loginUseCase(
                    LoginRequest(
                        email = currentState.email.trim(),
                        password = currentState.password
                    )
                )

                saveLoginSessionUseCase(result)

                val session = getLoginSessionUseCase().first()

                if (session != null) {
                    Log.d(
                        "LOGIN_SESSION",
                        "Access token exists: ${
                            session.accessToken.isNotBlank()
                        }"
                    )

                    Log.d(
                        "LOGIN_SESSION",
                        "Refresh token exists: ${
                            session.refreshToken.isNotBlank()
                        }"
                    )

                    Log.d(
                        "LOGIN_SESSION",
                        "User ID: ${session.user.id}"
                    )

                    Log.d(
                        "LOGIN_SESSION",
                        "User Name: ${session.user.firstName} ${session.user.lastName}"
                    )

                    Log.d(
                        "LOGIN_SESSION",
                        "User Email: ${session.user.email}"
                    )

                    Log.d(
                        "LOGIN_SESSION",
                        "User Role: ${session.user.role}"
                    )
                }

                _uiState.update {
                    it.copy(
                        isLoading = false
                    )
                }

                _uiEvent.emit(
                    LoginUiEvent.ShowSuccess(
                        UiText.Dynamic(result.message)
                    )
                )

                _uiEvent.emit(
                    LoginUiEvent.LoginSuccess
                )

                // Navigate to dashboard

            } catch (exception: Exception) {

                val message =
                    NetworkErrorHandler.getMessage(exception)

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        generalError = message
                    )
                }

                _uiEvent.emit(
                    LoginUiEvent.ShowError(message)
                )
            }
        }
    }
}

private fun validateEmail(
    email: String
): UiText? {

    if (email.isBlank()) {
        return UiText.StringRes(
            R.string.login_error_email_required
        )
    }

    if (!Patterns.EMAIL_ADDRESS
            .matcher(email.trim())
            .matches()
    ) {
        return UiText.StringRes(
            R.string.login_error_email_invalid
        )
    }

    return null
}

private fun validatePassword(
    password: String
): UiText? {

    if (password.isBlank()) {
        return UiText.StringRes(
            R.string.login_error_password_required
        )
    }

    if (password.length < 8) {
        return UiText.StringRes(
            resId = R.string.login_error_password_min_length,
            args = listOf(8)
        )
    }

    if (password.length > 14) {
        return UiText.StringRes(
            resId = R.string.login_error_password_max_length,
            args = listOf(14)
        )
    }

    return null
}
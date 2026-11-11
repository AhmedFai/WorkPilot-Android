package com.faizan.workpilot.features.companyManagement.presentation.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.core.network.error.NetworkErrorHandler
import com.faizan.workpilot.features.companyManagement.domain.usecase.admin.CreateCompanyAdminUseCase
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.CreateCompanyAdminUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.CreateCompanyAdminUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class CreateCompanyAdminViewModel @Inject constructor(
    private val createCompanyAdminUseCase: CreateCompanyAdminUseCase,
    private val networkErrorHandler: NetworkErrorHandler
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        CreateCompanyAdminUiState()
    )

    val uiState = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<CreateCompanyAdminUiEvent>()

    val events = _events.asSharedFlow()

    // First Name
    fun updateFirstName(value: String) {
        _uiState.update {
            it.copy(
                firstName = value,
                error = null
            )
        }
    }

    // Last Name
    fun updateLastName(value: String) {
        _uiState.update {
            it.copy(
                lastName = value,
                error = null
            )
        }
    }

    // Email
    fun updateEmail(value: String) {
        _uiState.update {
            it.copy(
                email = value,
                error = null
            )
        }
    }

    // Password
    fun updatePassword(value: String) {
        _uiState.update {
            it.copy(
                password = value,
                error = null
            )
        }
    }

    // Phone Number
    fun updatePhoneNumber(value: String) {
        _uiState.update {
            it.copy(
                phoneNumber = value,
                error = null
            )
        }
    }

    // Create Admin
    fun createCompanyAdmin(companyId: Long) {

        val state = _uiState.value

        if (state.isLoading) return

        val validationError = validateForm(state)

        if (validationError != null) {
            _uiState.update {
                it.copy(error = validationError)
            }

            viewModelScope.launch {
                _events.emit(
                    CreateCompanyAdminUiEvent.ShowError(
                        message = validationError
                    )
                )
            }

            return
        }

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val admin = createCompanyAdminUseCase(
                    companyId = companyId,
                    firstName = state.firstName.trim(),
                    lastName = state.lastName.trim(),
                    email = state.email.trim(),
                    phoneNumber = state.phoneNumber.trim(),
                    password = state.password
                )

                _uiState.update {
                    it.copy(isLoading = false)
                }

                _events.emit(
                    CreateCompanyAdminUiEvent.AdminCreated(
                        admin = admin
                    )
                )

            } catch (exception: CancellationException) {
                throw exception

            } catch (exception: Exception) {

                val networkError = networkErrorHandler.handle(exception)

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = networkError.message
                    )
                }

                _events.emit(
                    CreateCompanyAdminUiEvent.ShowError(
                        message = networkError.message
                    )
                )
            }
        }
    }

    // Form Validation
    private fun validateForm(
        state: CreateCompanyAdminUiState
    ): UiText? {

        if (state.firstName.isBlank()) {
            return UiText.StringRes(
                R.string.admin_first_name_required
            )
        }

        if (state.lastName.isBlank()) {
            return UiText.StringRes(
                R.string.admin_last_name_required
            )
        }

        if (state.phoneNumber.isBlank()) {
            return UiText.StringRes(
                R.string.admin_phone_required
            )
        }

        if (!state.phoneNumber.matches(Regex("^[0-9]{10}$"))) {
            return UiText.StringRes(
                R.string.admin_phone_invalid
            )
        }

        if (state.email.isBlank()) {
            return UiText.StringRes(
                R.string.admin_email_required
            )
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(
                state.email.trim()
            ).matches()
        ) {
            return UiText.StringRes(
                R.string.admin_email_invalid
            )
        }

        if (state.password.isBlank()) {
            return UiText.StringRes(
                R.string.admin_password_required
            )
        }

        if (state.password.length !in 8..14) {
            return UiText.StringRes(
                R.string.admin_password_length_invalid
            )
        }

        return null
    }
}
package com.faizan.workpilot.features.company.presentation.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.core.network.error.NetworkErrorHandler
import com.faizan.workpilot.features.company.domain.usecase.CreateCompanyUseCase
import com.faizan.workpilot.features.company.presentation.model.CreateCompanyUiEvent
import com.faizan.workpilot.features.company.presentation.model.CreateCompanyUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateCompanyViewModel @Inject constructor(
    private val createCompanyUseCase: CreateCompanyUseCase,
    private val networkErrorHandler: NetworkErrorHandler
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        CreateCompanyUiState()
    )

    val uiState: StateFlow<CreateCompanyUiState> =
        _uiState.asStateFlow()

    private val _uiEvent =
        MutableSharedFlow<CreateCompanyUiEvent>()

    val uiEvent: SharedFlow<CreateCompanyUiEvent> =
        _uiEvent.asSharedFlow()

    fun onNameChanged(name: String) {
        _uiState.update {
            it.copy(
                nameError = null,
                generalError = null
            )
        }
    }

    fun onEmailChanged(email: String) {
        _uiState.update {
            it.copy(
                emailError = null,
                generalError = null
            )
        }
    }

    fun createCompany(
        name: String,
        email: String,
        phone: String?,
        website: String?,
        addressLine1: String?,
        addressLine2: String?,
        city: String?,
        state: String?,
        postalCode: String?,
        country: String?
    ) {

        if (_uiState.value.isLoading) {
            return
        }

        val nameError = validateName(name)

        val emailError = validateEmail(email)

        if (nameError != null || emailError != null) {
            _uiState.update {
                it.copy(
                    nameError = nameError,
                    emailError = emailError
                )
            }
            return
        }

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true,
                    generalError = null,
                    nameError = null,
                    emailError = null
                )
            }

            try {

                val result = createCompanyUseCase(
                    name = name.trim(),
                    email = email.trim(),
                    phone = phone,
                    website = website,
                    addressLine1 = addressLine1,
                    addressLine2 = addressLine2,
                    city = city,
                    state = state,
                    postalCode = postalCode,
                    country = country
                )

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        company = result.company
                    )
                }

                _uiEvent.emit(
                    CreateCompanyUiEvent.ShowSuccess(
                        UiText.Dynamic(
                            result.message
                        )
                    )
                )

                _uiEvent.emit(
                    CreateCompanyUiEvent.CompanyCreated
                )

            } catch (exception: Exception) {

                val networkError =
                    networkErrorHandler.handle(exception)

                val message =
                    networkError.message

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        generalError = message
                    )
                }

                _uiEvent.emit(
                    CreateCompanyUiEvent.ShowError(
                        message
                    )
                )
            }
        }
    }
}

private fun validateName(
    name: String
): UiText? {

    if (name.isBlank()) {
        return UiText.StringRes(
            R.string.company_error_name_required
        )
    }

    return null
}

private fun validateEmail(
    email: String
): UiText? {

    if (email.isBlank()) {
        return UiText.StringRes(
            R.string.company_error_email_required
        )
    }

    if (!Patterns.EMAIL_ADDRESS
            .matcher(email.trim())
            .matches()
    ) {
        return UiText.StringRes(
            R.string.company_error_email_invalid
        )
    }

    return null
}
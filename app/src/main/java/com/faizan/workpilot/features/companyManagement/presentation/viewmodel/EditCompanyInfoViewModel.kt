package com.faizan.workpilot.features.companyManagement.presentation.viewmodel.editCompanyInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.core.network.error.NetworkErrorHandler
import com.faizan.workpilot.features.companyManagement.domain.model.editCompanyInfo.UpdateCompanyInfo
import com.faizan.workpilot.features.companyManagement.domain.usecase.companyInfo.GetCompanyInfoUseCase
import com.faizan.workpilot.features.companyManagement.domain.usecase.editCompanyInfo.UpdateCompanyInfoUseCase
import com.faizan.workpilot.features.companyManagement.presentation.model.editCompanyInfo.EditCompanyInfoUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.model.editCompanyInfo.EditCompanyInfoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class EditCompanyInfoViewModel @Inject constructor(
    private val getCompanyInfoUseCase: GetCompanyInfoUseCase,
    private val updateCompanyInfoUseCase: UpdateCompanyInfoUseCase,
    private val networkErrorHandler: NetworkErrorHandler
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        EditCompanyInfoUiState()
    )

    val uiState = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<EditCompanyInfoUiEvent>()

    val events = _events.asSharedFlow()

    fun getCompanyInfo(companyId: Long) {
        if (_uiState.value.isLoading || _uiState.value.companyInfo != null) {
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
                val companyInfo = getCompanyInfoUseCase(
                    companyId = companyId
                )

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        companyInfo = companyInfo,
                        name = companyInfo.name,
                        email = companyInfo.email,
                        phone = companyInfo.phone.orEmpty(),
                        website = companyInfo.website.orEmpty(),
                        addressLine1 = companyInfo.addressLine1.orEmpty(),
                        addressLine2 = companyInfo.addressLine2.orEmpty(),
                        city = companyInfo.city.orEmpty(),
                        state = companyInfo.state.orEmpty(),
                        postalCode = companyInfo.postalCode.orEmpty(),
                        country = companyInfo.country.orEmpty(),
                        error = null
                    )
                }

            } catch (exception: Exception) {
                val networkError = networkErrorHandler.handle(
                    exception
                )

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = networkError.message
                    )
                }

                _events.emit(
                    EditCompanyInfoUiEvent.ShowError(
                        message = networkError.message
                    )
                )
            }
        }
    }

    fun onNameChange(value: String) {
        _uiState.update {
            it.copy(
                name = value,
                nameError = null
            )
        }
    }

    fun onEmailChange(value: String) {
        _uiState.update {
            it.copy(
                email = value,
                emailError = null
            )
        }
    }

    fun onPhoneChange(value: String) {
        _uiState.update {
            it.copy(phone = value)
        }
    }

    fun onWebsiteChange(value: String) {
        _uiState.update {
            it.copy(website = value)
        }
    }

    fun onAddressLine1Change(value: String) {
        _uiState.update {
            it.copy(addressLine1 = value)
        }
    }

    fun onAddressLine2Change(value: String) {
        _uiState.update {
            it.copy(addressLine2 = value)
        }
    }

    fun onCityChange(value: String) {
        _uiState.update {
            it.copy(city = value)
        }
    }

    fun onStateChange(value: String) {
        _uiState.update {
            it.copy(state = value)
        }
    }

    fun onPostalCodeChange(value: String) {
        _uiState.update {
            it.copy(postalCode = value)
        }
    }

    fun onCountryChange(value: String) {
        _uiState.update {
            it.copy(country = value)
        }
    }

    fun updateCompany(companyId: Long) {
        if (_uiState.value.isSaving) {
            return
        }

        if (!validateForm()) {
            return
        }

        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                val state = _uiState.value

                val updatedCompany = updateCompanyInfoUseCase(
                    companyId = companyId,
                    companyInfo = UpdateCompanyInfo(
                        name = state.name.trim(),
                        email = state.email.trim(),
                        phone = state.phone.toNullable(),
                        website = state.website.toNullable(),
                        addressLine1 = state.addressLine1.toNullable(),
                        addressLine2 = state.addressLine2.toNullable(),
                        city = state.city.toNullable(),
                        state = state.state.toNullable(),
                        postalCode = state.postalCode.toNullable(),
                        country = state.country.toNullable()
                    )
                )

                _uiState.update {
                    it.copy(
                        isSaving = false,
                        companyInfo = updatedCompany,
                        name = updatedCompany.name,
                        email = updatedCompany.email,
                        phone = updatedCompany.phone.orEmpty(),
                        website = updatedCompany.website.orEmpty(),
                        addressLine1 = updatedCompany.addressLine1.orEmpty(),
                        addressLine2 = updatedCompany.addressLine2.orEmpty(),
                        city = updatedCompany.city.orEmpty(),
                        state = updatedCompany.state.orEmpty(),
                        postalCode = updatedCompany.postalCode.orEmpty(),
                        country = updatedCompany.country.orEmpty(),
                        nameError = null,
                        emailError = null,
                        error = null
                    )
                }

                _events.emit(
                    EditCompanyInfoUiEvent.UpdateSuccess
                )

            } catch (exception: Exception) {
                val networkError = networkErrorHandler.handle(
                    exception
                )

                _uiState.update {
                    it.copy(
                        isSaving = false,
                        error = networkError.message
                    )
                }

                _events.emit(
                    EditCompanyInfoUiEvent.ShowError(
                        message = networkError.message
                    )
                )
            }
        }
    }

    private fun validateForm(): Boolean {
        val state = _uiState.value

        var isValid = true

        if (state.name.isBlank()) {
            _uiState.update {
                it.copy(
                    nameError = UiText.StringRes(
                        R.string.company_information_name_required
                    )
                )
            }

            isValid = false
        }

        if (state.email.isBlank()) {
            _uiState.update {
                it.copy(
                    emailError = UiText.StringRes(
                        R.string.company_information_email_required
                    )
                )
            }

            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(
                state.email.trim()
            ).matches()
        ) {
            _uiState.update {
                it.copy(
                    emailError = UiText.StringRes(
                        R.string.company_information_email_invalid
                    )
                )
            }

            isValid = false
        }

        return isValid
    }

    private fun String.toNullable(): String? {
        return trim().takeIf { it.isNotEmpty() }
    }
}
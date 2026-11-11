package com.faizan.workpilot.features.companyManagement.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.core.network.error.NetworkErrorHandler
import com.faizan.workpilot.features.companyManagement.domain.usecase.admin.GetCompanyAdminDetailsUseCase
import com.faizan.workpilot.features.companyManagement.domain.usecase.admin.UpdateCompanyAdminUseCase
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.EditCompanyAdminUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.EditCompanyAdminUiState
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
class EditCompanyAdminViewModel @Inject constructor(
    private val getCompanyAdminDetailsUseCase: GetCompanyAdminDetailsUseCase,
    private val updateCompanyAdminUseCase: UpdateCompanyAdminUseCase,
    private val networkErrorHandler: NetworkErrorHandler
) : ViewModel() {

    private val _uiState = MutableStateFlow(EditCompanyAdminUiState())
    val uiState = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<EditCompanyAdminUiEvent>()
    val events = _events.asSharedFlow()

    // Load Admin Details
    fun loadAdminDetails(companyId: Long, adminId: Long) {
        if (_uiState.value.isLoading || _uiState.value.admin != null) return

        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true, error = null)
            }

            try {
                val admin = getCompanyAdminDetailsUseCase(
                    companyId = companyId,
                    adminId = adminId
                )

                _uiState.update {
                    it.copy(
                        admin = admin,
                        firstName = admin.firstName,
                        lastName = admin.lastName,
                        email = admin.email,
                        phoneNumber = admin.phoneNumber,
                        designation = admin.designation,
                        isLoading = false,
                        error = null
                    )
                }

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
                    EditCompanyAdminUiEvent.ShowError(
                        message = networkError.message
                    )
                )
            }
        }
    }

    // First Name
    fun updateFirstName(value: String) {
        _uiState.update {
            it.copy(firstName = value, error = null)
        }
    }

    // Last Name
    fun updateLastName(value: String) {
        _uiState.update {
            it.copy(lastName = value, error = null)
        }
    }

    // Phone Number
    fun updatePhoneNumber(value: String) {
        _uiState.update {
            it.copy(phoneNumber = value, error = null)
        }
    }

    // Update Admin
    fun updateCompanyAdmin(companyId: Long, adminId: Long) {
        val state = _uiState.value

        if (state.isUpdating || state.isLoading) return

        val validationError = validateForm(state)

        if (validationError != null) {
            _uiState.update {
                it.copy(error = validationError)
            }

            viewModelScope.launch {
                _events.emit(
                    EditCompanyAdminUiEvent.ShowError(validationError)
                )
            }
            return
        }

        viewModelScope.launch {
            _uiState.update {
                it.copy(isUpdating = true, error = null)
            }

            try {
                val result = updateCompanyAdminUseCase(
                    companyId = companyId,
                    adminId = adminId,
                    firstName = state.firstName.trim(),
                    lastName = state.lastName.trim(),
                    phoneNumber = state.phoneNumber.trim()
                )

                val updatedAdmin = result.admin

                _uiState.update {
                    it.copy(
                        admin = updatedAdmin,
                        firstName = updatedAdmin.firstName,
                        lastName = updatedAdmin.lastName,
                        email = updatedAdmin.email,
                        phoneNumber = updatedAdmin.phoneNumber,
                        designation = updatedAdmin.designation,
                        isUpdating = false,
                        error = null
                    )
                }

                _events.emit(
                    EditCompanyAdminUiEvent.AdminUpdated(
                        message = result.message
                    )
                )

            } catch (exception: CancellationException) {
                throw exception

            } catch (exception: Exception) {
                val networkError = networkErrorHandler.handle(exception)

                _uiState.update {
                    it.copy(
                        isUpdating = false,
                        error = networkError.message
                    )
                }

                _events.emit(
                    EditCompanyAdminUiEvent.ShowError(
                        message = networkError.message
                    )
                )
            }
        }
    }

    // Form Validation
    private fun validateForm(
        state: EditCompanyAdminUiState
    ): UiText? {

        if (state.firstName.isBlank()) {
            return UiText.StringRes(R.string.admin_first_name_required)
        }

        if (state.lastName.isBlank()) {
            return UiText.StringRes(R.string.admin_last_name_required)
        }

        if (state.phoneNumber.isBlank()) {
            return UiText.StringRes(R.string.admin_phone_required)
        }

        if (!state.phoneNumber.matches(Regex("^[0-9]{10}$"))) {
            return UiText.StringRes(R.string.admin_phone_invalid)
        }

        return null
    }
}
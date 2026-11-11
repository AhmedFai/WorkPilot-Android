package com.faizan.workpilot.features.companyManagement.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.core.network.error.NetworkErrorHandler
import com.faizan.workpilot.features.companyManagement.domain.usecase.admin.GetCompanyAdminDetailsUseCase
import com.faizan.workpilot.features.companyManagement.domain.usecase.admin.UpdateCompanyAdminStatusUseCase
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.CompanyAdminDetailsUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.CompanyAdminDetailsUiState
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
class CompanyAdminDetailsViewModel @Inject constructor(
    private val getCompanyAdminDetailsUseCase: GetCompanyAdminDetailsUseCase,
    private val updateCompanyAdminStatusUseCase: UpdateCompanyAdminStatusUseCase,
    private val networkErrorHandler: NetworkErrorHandler
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        CompanyAdminDetailsUiState()
    )

    val uiState = _uiState.asStateFlow()

    private val _events =
        MutableSharedFlow<CompanyAdminDetailsUiEvent>()

    val events = _events.asSharedFlow()

    // Get Admin Details
    fun getCompanyAdminDetails(
        companyId: Long,
        adminId: Long
    ) {
        if (_uiState.value.isLoading) return

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val result = getCompanyAdminDetailsUseCase(
                    companyId = companyId,
                    adminId = adminId
                )

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        admin = result,
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
                    CompanyAdminDetailsUiEvent.ShowError(
                        message = networkError.message
                    )
                )
            }
        }
    }

    // Activate / Deactivate Admin
    fun updateCompanyAdminStatus(
        companyId: Long,
        adminId: Long,
        active: Boolean
    ) {
        if (_uiState.value.isUpdatingStatus) return

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isUpdatingStatus = true,
                    error = null
                )
            }

            try {
                val updatedAdmin = updateCompanyAdminStatusUseCase(
                    companyId = companyId,
                    adminId = adminId,
                    active = active
                )

                _uiState.update {
                    it.copy(
                        isUpdatingStatus = false,
                        admin = updatedAdmin,
                        error = null
                    )
                }

                _events.emit(
                    CompanyAdminDetailsUiEvent.StatusUpdated
                )

            } catch (exception: CancellationException) {
                throw exception

            } catch (exception: Exception) {

                val networkError = networkErrorHandler.handle(exception)

                _uiState.update {
                    it.copy(
                        isUpdatingStatus = false,
                        error = networkError.message
                    )
                }

                _events.emit(
                    CompanyAdminDetailsUiEvent.ShowError(
                        message = networkError.message
                    )
                )
            }
        }
    }
}
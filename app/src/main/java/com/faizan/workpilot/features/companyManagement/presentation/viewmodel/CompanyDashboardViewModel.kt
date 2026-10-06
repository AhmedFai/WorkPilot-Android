package com.faizan.workpilot.features.companyManagement.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.core.network.error.NetworkErrorHandler
import com.faizan.workpilot.features.companyManagement.domain.model.companyStatus.UpdateCompanyStatus
import com.faizan.workpilot.features.companyManagement.domain.usecase.companyStatus.UpdateCompanyStatusUseCase
import com.faizan.workpilot.features.companyManagement.domain.usecase.dashboard.GetCompanyDashboardUseCase
import com.faizan.workpilot.features.companyManagement.presentation.model.dashboard.CompanyDashboardUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.model.dashboard.CompanyDashboardUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyDashboardViewModel @Inject constructor(
    private val getCompanyDashboardUseCase: GetCompanyDashboardUseCase,
    private val updateCompanyStatusUseCase: UpdateCompanyStatusUseCase,
    private val networkErrorHandler: NetworkErrorHandler
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            CompanyDashboardUiState()
        )

    val uiState =
        _uiState.asStateFlow()

    private val _events =
        MutableSharedFlow<CompanyDashboardUiEvent>()

    val events =
        _events.asSharedFlow()

    fun getCompanyDashboard(
        companyId: Long
    ) {

        if (_uiState.value.isLoading || _uiState.value.dashboard != null) {
            return
        }

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }
            delay(2000)
            try {

                val dashboard =
                    getCompanyDashboardUseCase(
                        companyId
                    )

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        dashboard = dashboard,
                        error = null
                    )
                }

            } catch (exception: Exception) {

                val networkError =
                    networkErrorHandler.handle(
                        exception
                    )

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = networkError.message
                    )
                }

                _events.emit(
                    CompanyDashboardUiEvent.ShowError(
                        message = networkError.message
                    )
                )
            }
        }
    }

    fun retry(
        companyId: Long
    ) {
        getCompanyDashboard(companyId)
    }

    fun updateCompanyStatus(
        companyId: Long,
        active: Boolean
    ) {
        if (_uiState.value.isUpdating) {
            return
        }

        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isUpdating = true,
                    error = null
                )
            }

            try {
                val updatedCompany =
                    updateCompanyStatusUseCase(
                        companyId = companyId,
                        status = UpdateCompanyStatus(
                            active = active
                        )
                    )

                _uiState.update { state ->
                    state.copy(
                        isUpdating = false,
                        dashboard = state.dashboard?.copy(
                            company = state.dashboard.company.copy(
                                active = updatedCompany.active
                            )
                        ),
                        error = null
                    )
                }

            } catch (exception: Exception) {

                val networkError =
                    networkErrorHandler.handle(exception)

                _uiState.update {
                    it.copy(
                        isUpdating = false,
                        error = networkError.message
                    )
                }

                _events.emit(
                    CompanyDashboardUiEvent.ShowError(
                        message = networkError.message
                    )
                )
            }
        }
    }


    fun refreshCompanyDashboard(
        companyId: Long
    ) {
        if (_uiState.value.isLoading) {
            return
        }

        viewModelScope.launch {
            try {
                val dashboard =
                    getCompanyDashboardUseCase(companyId)

                _uiState.update {
                    it.copy(
                        dashboard = dashboard,
                        error = null
                    )
                }
            } catch (exception: Exception) {

                val networkError =
                    networkErrorHandler.handle(exception)

                _uiState.update {
                    it.copy(
                        error = networkError.message
                    )
                }

                _events.emit(
                    CompanyDashboardUiEvent.ShowError(
                        message = networkError.message
                    )
                )
            }
        }
    }

}
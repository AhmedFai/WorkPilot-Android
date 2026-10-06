package com.faizan.workpilot.features.companyManagement.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.core.network.error.NetworkErrorHandler
import com.faizan.workpilot.features.companyManagement.domain.model.companyStatus.UpdateCompanyStatus
import com.faizan.workpilot.features.companyManagement.domain.usecase.companyInfo.GetCompanyInfoUseCase
import com.faizan.workpilot.features.companyManagement.domain.usecase.companyStatus.UpdateCompanyStatusUseCase
import com.faizan.workpilot.features.companyManagement.presentation.model.companyStatus.CompanyStatusUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.model.companyStatus.CompanyStatusUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class CompanyStatusViewModel @Inject constructor(
    private val getCompanyInfoUseCase: GetCompanyInfoUseCase,
    private val updateCompanyStatusUseCase: UpdateCompanyStatusUseCase,
    private val networkErrorHandler: NetworkErrorHandler
) : ViewModel() {

    private val _uiState = MutableStateFlow(CompanyStatusUiState())
    val uiState = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<CompanyStatusUiEvent>()
    val events = _events.asSharedFlow()

    fun getCompanyStatus(companyId: Long) {
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
                val companyInfo = getCompanyInfoUseCase(companyId)

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        companyInfo = companyInfo,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                val networkError = networkErrorHandler.handle(exception)

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = networkError.message
                    )
                }

                _events.emit(
                    CompanyStatusUiEvent.ShowError(
                        networkError.message
                    )
                )
            }
        }
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
                val updatedCompany = updateCompanyStatusUseCase(
                    companyId = companyId,
                    status = UpdateCompanyStatus(
                        active = active
                    )
                )

                _uiState.update {
                    it.copy(
                        isUpdating = false,
                        companyInfo = updatedCompany,
                        error = null
                    )
                }
                _events.emit(
                    CompanyStatusUiEvent.StatusUpdated
                )
            } catch (exception: Exception) {
                val networkError = networkErrorHandler.handle(exception)

                _uiState.update {
                    it.copy(
                        isUpdating = false,
                        error = networkError.message
                    )
                }

                _events.emit(
                    CompanyStatusUiEvent.ShowError(
                        networkError.message
                    )
                )
            }
        }
    }

    fun retry(companyId: Long) {
        _uiState.update {
            it.copy(companyInfo = null)
        }

        getCompanyStatus(companyId)
    }
}
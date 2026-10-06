package com.faizan.workpilot.features.companyManagement.presentation.viewmodel.companyInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.core.network.error.NetworkErrorHandler
import com.faizan.workpilot.features.companyManagement.domain.usecase.companyInfo.GetCompanyInfoUseCase
import com.faizan.workpilot.features.companyManagement.presentation.model.companyInfo.CompanyInfoUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.model.companyInfo.CompanyInfoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class CompanyInfoViewModel @Inject constructor(
    private val getCompanyInfoUseCase: GetCompanyInfoUseCase,
    private val networkErrorHandler: NetworkErrorHandler
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        CompanyInfoUiState()
    )
    val uiState = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<CompanyInfoUiEvent>()
    val events = _events.asSharedFlow()

    fun getCompanyInfo(companyId: Long) {
        if (_uiState.value.isLoading) return

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
                    CompanyInfoUiEvent.ShowError(
                        message = networkError.message
                    )
                )
            }
        }
    }

    fun retry(companyId: Long) {
        getCompanyInfo(companyId)
    }
}
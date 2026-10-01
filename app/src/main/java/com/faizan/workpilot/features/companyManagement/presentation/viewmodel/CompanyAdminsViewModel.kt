package com.faizan.workpilot.features.companyManagement.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.core.network.error.NetworkErrorHandler
import com.faizan.workpilot.features.companyManagement.domain.usecase.admin.GetCompanyAdminsUseCase
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.CompanyAdminsUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.CompanyAdminsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class CompanyAdminsViewModel @Inject constructor(
    private val getCompanyAdminsUseCase: GetCompanyAdminsUseCase,
    private val networkErrorHandler: NetworkErrorHandler
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        CompanyAdminsUiState()
    )

    val uiState = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<CompanyAdminsUiEvent>()

    val events = _events.asSharedFlow()

    fun getCompanyAdmins(
        companyId: Long
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
                val result = getCompanyAdminsUseCase(
                    companyId = companyId,
                    page = 0,
                    size = 20,
                    search = _uiState.value.searchQuery
                        .takeIf { it.isNotBlank() }
                )

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        admins = result.admins,
                        currentPage = result.page,
                        totalPages = result.totalPages,
                        totalElements = result.totalElements,
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
                    CompanyAdminsUiEvent.ShowError(
                        message = networkError.message
                    )
                )
            }
        }
    }

    fun loadNextPage(
        companyId: Long
    ) {
        val state = _uiState.value

        if (
            state.isLoading ||
            state.isLoadingMore ||
            !state.hasMorePages
        ) {
            return
        }

        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoadingMore = true
                )
            }

            try {
                val nextPage = state.currentPage + 1

                val result = getCompanyAdminsUseCase(
                    companyId = companyId,
                    page = nextPage,
                    size = 20,
                    search = state.searchQuery
                        .takeIf { it.isNotBlank() }
                )

                _uiState.update {
                    it.copy(
                        isLoadingMore = false,
                        admins = it.admins + result.admins,
                        currentPage = result.page,
                        totalPages = result.totalPages,
                        totalElements = result.totalElements,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                val networkError = networkErrorHandler.handle(exception)

                _uiState.update {
                    it.copy(
                        isLoadingMore = false
                    )
                }

                _events.emit(
                    CompanyAdminsUiEvent.ShowError(
                        message = networkError.message
                    )
                )
            }
        }
    }

    fun searchAdmins(
        companyId: Long,
        query: String
    ) {
        _uiState.update {
            it.copy(
                searchQuery = query,
                currentPage = 0,
                totalPages = 0,
                totalElements = 0
            )
        }

        getCompanyAdmins(companyId)
    }

    fun retry(
        companyId: Long
    ) {
        getCompanyAdmins(companyId)
    }
}
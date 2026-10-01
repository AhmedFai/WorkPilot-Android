package com.faizan.workpilot.features.companyManagement.presentation.model.admin

import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdmin

data class CompanyAdminsUiState(
    val isLoading: Boolean = false,
    val isLoadingMore: Boolean = false,
    val admins: List<CompanyAdmin> = emptyList(),
    val searchQuery: String = "",
    val currentPage: Int = 0,
    val totalPages: Int = 0,
    val totalElements: Long = 0,
    val error: UiText? = null
) {
    val hasMorePages: Boolean
        get() = currentPage < totalPages - 1
}
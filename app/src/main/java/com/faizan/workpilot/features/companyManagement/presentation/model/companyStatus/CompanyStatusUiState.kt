package com.faizan.workpilot.features.companyManagement.presentation.model.companyStatus

import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo

data class CompanyStatusUiState(
    val isLoading: Boolean = false,
    val isUpdating: Boolean = false,
    val companyInfo: CompanyInfo? = null,
    val error: UiText? = null
)
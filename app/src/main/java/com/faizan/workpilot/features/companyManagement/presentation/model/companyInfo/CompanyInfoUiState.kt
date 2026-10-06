package com.faizan.workpilot.features.companyManagement.presentation.model.companyInfo

import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo

data class CompanyInfoUiState(
    val isLoading: Boolean = false,
    val companyInfo: CompanyInfo? = null,
    val error: UiText? = null
)

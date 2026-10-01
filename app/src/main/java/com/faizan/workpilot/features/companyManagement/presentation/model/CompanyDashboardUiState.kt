package com.faizan.workpilot.features.companyManagement.presentation.model

import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.features.companyManagement.domain.model.CompanyDashboard

data class CompanyDashboardUiState(
    val isLoading: Boolean = false,
    val dashboard: CompanyDashboard? = null,
    val error: UiText? = null
)
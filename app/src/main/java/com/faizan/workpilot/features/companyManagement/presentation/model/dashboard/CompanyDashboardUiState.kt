package com.faizan.workpilot.features.companyManagement.presentation.model.dashboard

import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.features.companyManagement.domain.model.dashboard.CompanyDashboard

data class CompanyDashboardUiState(
    val isLoading: Boolean = false,
    val dashboard: CompanyDashboard? = null,
    val error: UiText? = null
)
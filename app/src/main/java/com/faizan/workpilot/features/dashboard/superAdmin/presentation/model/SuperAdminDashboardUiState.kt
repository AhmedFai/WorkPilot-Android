package com.faizan.workpilot.features.dashboard.superAdmin.presentation.model

import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.core.network.error.NetworkError
import com.faizan.workpilot.features.dashboard.superAdmin.domain.model.SuperAdminCompany

data class SuperAdminDashboardUiState(
    val greeting: UiText = UiText.StringRes(
        R.string.dashboard_greeting_morning
    ),
    val userName: String = "",
    val isLoading: Boolean = false,
    val companies: List<SuperAdminCompany> = emptyList(),
    val error: NetworkError? = null
)
package com.faizan.workpilot.features.dashboard.admin.presentation.model

import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.core.network.error.NetworkError

data class DashboardUiState(
    val greeting: UiText = UiText.StringRes(
        R.string.dashboard_greeting_morning
    ),
    val userName: String = "",
    val company: com.faizan.workpilot.features.dashboard.admin.presentation.model.CompanyUiModel? = null,
    val employeeCount: Int = 0,
    val projectCount: Int = 0,
    val taskCount: Int = 0,
    val recentProjects: List<com.faizan.workpilot.features.dashboard.admin.presentation.model.RecentProjectUiModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: NetworkError? = null
)

package com.faizan.workpilot.features.dashboard.presentation.model

import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText

data class DashboardUiState(
    val greeting: UiText = UiText.StringRes(
        R.string.dashboard_greeting_morning
    ),
    val userName: String = "",
    val company: CompanyUiModel? = null,
    val employeeCount: Int = 0,
    val projectCount: Int = 0,
    val taskCount: Int = 0,
    val recentProjects: List<RecentProjectUiModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

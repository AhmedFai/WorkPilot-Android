package com.faizan.workpilot.features.dashboard.projectHead.presentation.model

import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.core.network.error.NetworkError
import com.faizan.workpilot.features.dashboard.projectHead.domain.model.ProjectHeadProject

data class ProjectHeadDashboardUiState(
    val greeting: UiText = UiText.StringRes(
        R.string.dashboard_greeting_morning
    ),
    val userName: String = "",
    val isLoading: Boolean = false,
    val currentProjectCount: Long = 0,
    val taskCount: Long = 0,
    val overdueTaskCount: Long = 0,
    val projects: List<ProjectHeadProject> = emptyList(),
    val error: NetworkError? = null
)

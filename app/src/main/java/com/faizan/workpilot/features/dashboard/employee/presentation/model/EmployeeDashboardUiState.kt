package com.faizan.workpilot.features.dashboard.employee.presentation.model

import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.core.network.error.NetworkError
import com.faizan.workpilot.features.dashboard.employee.domain.model.EmployeeTodayTask

data class EmployeeDashboardUiState(
    val greeting: UiText = UiText.StringRes(
        R.string.dashboard_greeting_morning
    ),
    val userName: String = "",
    val isLoading: Boolean = false,
    val myTaskCount: Long = 0,
    val completedTaskCount: Long = 0,
    val pendingTaskCount: Long = 0,
    val todayTasks: List<EmployeeTodayTask> = emptyList(),
    val error: NetworkError? = null
)
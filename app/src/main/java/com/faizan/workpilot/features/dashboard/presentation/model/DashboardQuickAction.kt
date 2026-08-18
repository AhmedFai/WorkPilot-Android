package com.faizan.workpilot.features.dashboard.presentation.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class DashboardQuickAction(
    @StringRes val titleRes: Int,
    val icon: ImageVector,
    val action: DashboardAction
)

enum class DashboardAction {
    USERS,
    PROJECTS,
    TASKS,
    REPORTS
}

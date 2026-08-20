package com.faizan.workpilot.features.dashboard.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faizan.workpilot.features.dashboard.presentation.model.DashboardAction
import com.faizan.workpilot.features.dashboard.presentation.viewmodel.DashboardViewModel

@Composable
fun AdminDashboardRoute(
    onUsersClick: () -> Unit,
    onProjectsClick: () -> Unit,
    onTasksClick: () -> Unit,
    onReportsClick: () -> Unit,
    onProjectClick: (Long) -> Unit,
    onSearchClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNotificationClick: () -> Unit,
    viewModel: DashboardViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState
        .collectAsStateWithLifecycle()

    AdminDashboardScreen(
        uiState = uiState,
        onUsersClick = onUsersClick,
        onProjectsClick = onProjectsClick,
        onTasksClick = onTasksClick,
        onReportsClick = onReportsClick,
        onProjectClick = onProjectClick,
        onSearchClick = onSearchClick,
        onProfileClick = onProfileClick,
        onNotificationClick = onNotificationClick,
        onRetry = viewModel::retry
    )
}
package com.faizan.workpilot.features.dashboard.projectHead.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faizan.workpilot.features.dashboard.projectHead.presentation.viewmodel.ProjectHeadDashboardViewModel

@Composable
fun ProjectHeadDashboardRoute(
    onSearchClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onProjectClick: (Long) -> Unit,
    viewModel: ProjectHeadDashboardViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ProjectHeadDashboardScreen(
        uiState = uiState,
        onSearchClick = onSearchClick,
        onProfileClick = onProfileClick,
        onNotificationClick = onNotificationClick,
        onProjectClick = onProjectClick,
        onRetry = {
            viewModel.retry()
        }
    )
}
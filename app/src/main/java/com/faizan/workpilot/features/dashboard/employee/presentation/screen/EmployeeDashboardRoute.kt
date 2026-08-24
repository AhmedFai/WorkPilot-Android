package com.faizan.workpilot.features.dashboard.employee.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faizan.workpilot.features.dashboard.employee.presentation.viewmodel.EmployeeDashboardViewModel

@Composable
fun EmployeeDashboardRoute(
    onSearchClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onSortClick: () -> Unit,
    onTaskClick: (Long) -> Unit,
    viewModel: EmployeeDashboardViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState
        .collectAsStateWithLifecycle()

    EmployeeDashboardScreen(
        uiState = uiState,
        onSearchClick = onSearchClick,
        onProfileClick = onProfileClick,
        onNotification = onNotificationClick,
        onSortClick = onSortClick,
        onTaskClick = onTaskClick,
        onRetry = viewModel::retry
    )
}
package com.faizan.workpilot.features.dashboard.superAdmin.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faizan.workpilot.features.dashboard.superAdmin.presentation.viewmodel.SuperAdminDashboardViewModel

@Composable
fun SuperAdminDashboardRoute(
    onCompanyClick: (Long) -> Unit,
    viewModel: SuperAdminDashboardViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    SuperAdminDashboardScreen(
        uiState = uiState,
        onCompanyClick = onCompanyClick,
        onRetry = {
            viewModel.retry()
        }
    )
}
package com.faizan.workpilot.features.dashboard.superAdmin.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faizan.workpilot.features.dashboard.superAdmin.presentation.viewmodel.SuperAdminDashboardViewModel

@Composable
fun SuperAdminDashboardRoute(
    onCompanyClick: (Long) -> Unit,
    onSearchClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onProfileClick: () -> Unit,
    onCreateCompanyClick: () -> Unit,
    companyCreated: Boolean,
    onCompanyCreatedHandled: () -> Unit,
    companyUpdated: Boolean,
    onCompanyUpdatedHandled: () -> Unit,
    viewModel: SuperAdminDashboardViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(companyCreated) {
        if (companyCreated) {
            viewModel.retry()
            onCompanyCreatedHandled()
        }
    }

    LaunchedEffect(companyUpdated) {
        if (companyUpdated) {
            viewModel.retry()
            onCompanyUpdatedHandled()
        }
    }

    SuperAdminDashboardScreen(
        uiState = uiState,
        onCompanyClick = onCompanyClick,
        onSearchClick = onSearchClick,
        onNotificationClick = onNotificationClick,
        onProfileClick = onProfileClick,
        onCreateCompanyClick = onCreateCompanyClick,
        onRetry = {
            viewModel.retry()
        }
    )
}
package com.faizan.workpilot.features.companyManagement.presentation.screen.companyStatus

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faizan.workpilot.features.companyManagement.presentation.model.companyStatus.CompanyStatusUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.viewmodel.CompanyStatusViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CompanyStatusRoute(
    companyId: Long,
    onBackClick: () -> Unit,
    viewModel: CompanyStatusViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    LaunchedEffect(companyId) {
        viewModel.getCompanyStatus(companyId)
    }

    LaunchedEffect(Unit) {
        viewModel.events.collectLatest { event ->
            when (event) {
                is CompanyStatusUiEvent.ShowError -> {
                    // Existing error handling will be wired here.
                }
                CompanyStatusUiEvent.StatusUpdated -> {
                    //onBackClick()
                }
            }
        }
    }

    CompanyStatusScreen(
        uiState = uiState,
        onBackClick = {
            onBackClick()
        },
        onRetry = {
            viewModel.retry(companyId)
        },
        onConfirmStatusChange = { active ->
            viewModel.updateCompanyStatus(
                companyId = companyId,
                active = active
            )
        }
    )
}
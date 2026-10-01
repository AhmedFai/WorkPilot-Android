package com.faizan.workpilot.features.companyManagement.presentation.screen

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faizan.workpilot.features.companyManagement.presentation.model.CompanyDashboardUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.viewmodel.CompanyDashboardViewModel

@Composable
fun CompanyDashboardRoute(
    companyId: Long,
    onBackClick: () -> Unit,
    viewModel: CompanyDashboardViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    val uiState by viewModel
        .uiState
        .collectAsStateWithLifecycle()

    LaunchedEffect(companyId) {

        viewModel.getCompanyDashboard(
            companyId = companyId
        )
    }

    LaunchedEffect(Unit) {

        viewModel.events.collect { event ->

            when (event) {

                is CompanyDashboardUiEvent.ShowError -> {

                    Toast.makeText(
                        context,
                        event.message.asString(context),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    CompanyDashboardScreen(
        uiState = uiState,
        onBackClick = onBackClick,
        onRetry = {
            viewModel.retry(
                companyId = companyId
            )
        }
    )
}
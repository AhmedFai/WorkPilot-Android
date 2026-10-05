package com.faizan.workpilot.features.companyManagement.presentation.screen.dashboard

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faizan.workpilot.features.companyManagement.presentation.model.dashboard.CompanyDashboardUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.viewmodel.CompanyAdminsViewModel
import com.faizan.workpilot.features.companyManagement.presentation.viewmodel.CompanyDashboardViewModel
import com.faizan.workpilot.features.companyManagement.presentation.viewmodel.companyInfo.CompanyInfoViewModel

@Composable
fun CompanyDashboardRoute(
    companyId: Long,
    onBackClick: () -> Unit,
    onCompanyInformationClick: () -> Unit,
    viewModel: CompanyDashboardViewModel = hiltViewModel(),
    adminsViewModel: CompanyAdminsViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    val uiState by viewModel
        .uiState
        .collectAsStateWithLifecycle()

    val adminsUiState by adminsViewModel
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
        adminsUiState = adminsUiState,
        onBackClick = onBackClick,
        onCompanyInformationClick = onCompanyInformationClick,
        onRetry = {
            viewModel.retry(
                companyId = companyId
            )
        },
        onLoadAdmins = {
            adminsViewModel.getCompanyAdmins(
                companyId = companyId
            )
        },
        onSearchQueryChange = { query ->
            adminsViewModel.searchAdmins(
                companyId = companyId,
                query = query
            )
        },
        onLoadNextPage = {
            adminsViewModel.loadNextPage(
                companyId = companyId
            )
        },
        onAddAdminClick = {
            // Later
        },
        onAdminClick = {
            // Later
        }
    )
}
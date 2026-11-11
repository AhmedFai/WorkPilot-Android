package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.CompanyAdminDetailsUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.viewmodel.CompanyAdminDetailsViewModel

@Composable
fun CompanyAdminDetailsRoute(
    companyId: Long,
    adminId: Long,
    onBackClick: () -> Unit,
    onEditAdminClick: () -> Unit,
    onViewActivityClick: () -> Unit,
    viewModel: CompanyAdminDetailsViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val uiState by viewModel
        .uiState
        .collectAsStateWithLifecycle()

    LaunchedEffect(companyId, adminId) {
        viewModel.getCompanyAdminDetails(
            companyId = companyId,
            adminId = adminId
        )
    }

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is CompanyAdminDetailsUiEvent.ShowError -> {
                    Toast.makeText(
                        context,
                        event.message.asString(context),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                CompanyAdminDetailsUiEvent.StatusUpdated -> Unit
            }
        }
    }

    CompanyAdminDetailsScreen(
        uiState = uiState,
        onBackClick = onBackClick,
        onRetry = {
            viewModel.getCompanyAdminDetails(
                companyId = companyId,
                adminId = adminId
            )
        },
        onEditAdminClick = onEditAdminClick,
        onViewActivityClick = onViewActivityClick,
        onDeactivateAdminClick = {
            val admin = uiState.admin ?: return@CompanyAdminDetailsScreen

            viewModel.updateCompanyAdminStatus(
                companyId = companyId,
                adminId = adminId,
                active = !admin.active
            )
        }
    )
}
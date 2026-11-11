package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails

import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.CreateCompanyAdminUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.viewmodel.CreateCompanyAdminViewModel


@Composable
fun CreateCompanyAdminRoute(
    companyId: Long,
    viewModel: CreateCompanyAdminViewModel = hiltViewModel(),
    onAdminCreated: () -> Unit,
    onBackClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is CreateCompanyAdminUiEvent.ShowError -> {
                    Toast.makeText(
                        context,
                        event.message.asString(context),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is CreateCompanyAdminUiEvent.AdminCreated -> {
                    onAdminCreated()
                }
            }
        }
    }

    CreateCompanyAdminScreen(
        uiState = uiState,
        onFirstNameChange = viewModel::updateFirstName,
        onLastNameChange = viewModel::updateLastName,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        onPhoneNumberChange = viewModel::updatePhoneNumber,
        onCreateClick = {
            viewModel.createCompanyAdmin(companyId)
        },
        onBackClick = onBackClick
    )
}
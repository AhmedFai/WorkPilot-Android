
package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.EditCompanyAdminUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.viewmodel.EditCompanyAdminViewModel

@Composable
fun EditCompanyAdminRoute(
    companyId: Long,
    adminId: Long,
    onBackClick: () -> Unit,
    viewModel: EditCompanyAdminViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(companyId, adminId) {
        viewModel.loadAdminDetails(
            companyId = companyId,
            adminId = adminId
        )
    }

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is EditCompanyAdminUiEvent.ShowError -> {
                    Toast.makeText(
                        context,
                        event.message.asString(context),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is EditCompanyAdminUiEvent.AdminUpdated -> {
                    Toast.makeText(
                        context,
                        event.message,
                        Toast.LENGTH_SHORT
                    ).show()

                    onBackClick()
                }
            }
        }
    }

    when {
        uiState.admin != null -> {
            EditCompanyAdminScreen(
                admin = uiState.admin!!,
                isLoading = uiState.isLoading || uiState.isUpdating,
                onSaveClick = { firstName, lastName, phoneNumber ->
                    viewModel.updateFirstName(firstName)
                    viewModel.updateLastName(lastName)
                    viewModel.updatePhoneNumber(phoneNumber)

                    viewModel.updateCompanyAdmin(
                        companyId = companyId,
                        adminId = adminId
                    )
                },
                onBackClick = onBackClick
            )
        }

        uiState.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MaterialTheme.dimens.screenPaddingHorizontal),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(
                        R.string.company_dashboard_something_went_wrong
                    )
                )

                Button(
                    onClick = {
                        viewModel.loadAdminDetails(
                            companyId = companyId,
                            adminId = adminId
                        )
                    }
                ) {
                    Text(
                        text = stringResource(
                            R.string.company_dashboard_retry
                        )
                    )
                }
            }
        }
    }
}

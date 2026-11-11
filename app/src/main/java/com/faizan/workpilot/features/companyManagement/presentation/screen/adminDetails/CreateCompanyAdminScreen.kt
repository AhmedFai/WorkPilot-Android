package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.CreateCompanyAdminUiState
import com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components.CompanyAdminForm
import com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components.CompanyAdminFormActions
import com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components.CompanyAdminFormHeader
import com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components.CompanyAdminFormInfoCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateCompanyAdminScreen(
    uiState: CreateCompanyAdminUiState,
    onFirstNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onCreateClick: () -> Unit,
    onBackClick: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.admin_create_heading))
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(
                horizontal = dimens.screenPaddingHorizontal,
                vertical = dimens.screenPaddingVertical
            ),
            verticalArrangement = Arrangement.spacedBy(dimens.spaceL)
        ) {

            item {
                CompanyAdminFormHeader(
                    isEditMode = false
                )
            }

            item {
                CompanyAdminForm(
                    firstName = uiState.firstName,
                    lastName = uiState.lastName,
                    email = uiState.email,
                    password = uiState.password,
                    phoneNumber = uiState.phoneNumber,
                    isEditMode = false,
                    isLoading = uiState.isLoading,
                    onFirstNameChange = onFirstNameChange,
                    onLastNameChange = onLastNameChange,
                    onEmailChange = onEmailChange,
                    onPasswordChange = onPasswordChange,
                    onPhoneNumberChange = onPhoneNumberChange
                )
            }

            item {
                CompanyAdminFormInfoCard(
                    isEditMode = false
                )
            }

            item {
                CompanyAdminFormActions(
                    isEditMode = false,
                    isLoading = uiState.isLoading,
                    onSubmit = onCreateClick,
                    onCancel = onBackClick
                )
            }
        }
    }
}
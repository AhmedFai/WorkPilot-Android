
package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminDetails
import com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components.CompanyAdminForm
import com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components.CompanyAdminFormHeader
import com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components.CompanyAdminFormInfoCard
import com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components.CompanyAdminFormActions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCompanyAdminScreen(
    admin: CompanyAdminDetails,
    isLoading: Boolean,
    onSaveClick: (String, String, String) -> Unit,
    onBackClick: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    var firstName by remember(admin.id) {
        mutableStateOf(admin.firstName)
    }

    var lastName by remember(admin.id) {
        mutableStateOf(admin.lastName)
    }

    var phoneNumber by remember(admin.id) {
        mutableStateOf(admin.phoneNumber)
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.admin_edit_heading))
                },
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
                .padding(innerPadding),
            contentPadding = PaddingValues(
                horizontal = dimens.screenPaddingHorizontal,
                vertical = dimens.screenPaddingVertical
            ),
            verticalArrangement = Arrangement.spacedBy(dimens.spaceL)
        ) {

            item {
                CompanyAdminFormHeader(
                    isEditMode = true
                )
            }

            item {
                CompanyAdminForm(
                    firstName = firstName,
                    lastName = lastName,
                    email = admin.email,
                    password = "",
                    phoneNumber = phoneNumber,
                    isEditMode = true,
                    isLoading = isLoading,
                    onFirstNameChange = { firstName = it },
                    onLastNameChange = { lastName = it },
                    onEmailChange = {},
                    onPasswordChange = {},
                    onPhoneNumberChange = { phoneNumber = it }
                )
            }

            item {
                CompanyAdminFormInfoCard(
                    isEditMode = true
                )
            }

            item {
                CompanyAdminFormActions(
                    isEditMode = true,
                    isLoading = isLoading,
                    onSubmit = {
                        onSaveClick(
                            firstName,
                            lastName,
                            phoneNumber
                        )
                    },
                    onCancel = onBackClick
                )
            }
        }
    }
}

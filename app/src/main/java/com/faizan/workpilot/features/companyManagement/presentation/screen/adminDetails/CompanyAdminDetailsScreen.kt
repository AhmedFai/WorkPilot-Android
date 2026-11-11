package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.CompanyAdminDetailsUiState
import com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components.AdminAccountStatusCard
import com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components.AdminDeactivateButton
import com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components.AdminDeactivateConfirmationDialog
import com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components.AdminDetailsHeader
import com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components.AdminInformationCard
import com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components.AdminProfileCard

@Composable
fun CompanyAdminDetailsScreen(
    uiState: CompanyAdminDetailsUiState,
    onBackClick: () -> Unit,
    onRetry: () -> Unit,
    onEditAdminClick: () -> Unit,
    onViewActivityClick: () -> Unit,
    onDeactivateAdminClick: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    var showDeactivateDialog by remember {
        mutableStateOf(false)
    }

    when {
        uiState.isLoading -> {
            // Shimmer will be added after basic layout verification.
        }

        uiState.admin != null -> {
            val admin = uiState.admin

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
            ) {
                AdminDetailsHeader(
                    onBackClick = onBackClick,
                    onEditAdminClick = onEditAdminClick,
                    onViewActivityClick = onViewActivityClick
                )

                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            horizontal = dimens.screenPaddingHorizontal
                        ),
                    contentPadding = PaddingValues(
                        top = dimens.spaceM,
                        bottom = dimens.spaceM
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        dimens.spaceM
                    )
                ) {
                    item {
                        AdminProfileCard(admin = admin)
                    }

                    item {
                        AdminInformationCard(admin = admin)
                    }

                    item {
                        AdminAccountStatusCard(admin = admin)
                    }

                    item {
                        AdminDeactivateButton(
                            isActive = admin.active,
                            isLoading = uiState.isUpdatingStatus,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    bottom = dimens.spaceS
                                ),
                            onClick = {
                                showDeactivateDialog = true
                            }
                        )
                    }
                }
            }

            if (showDeactivateDialog) {
                AdminDeactivateConfirmationDialog(
                    adminName = "${admin.firstName} ${admin.lastName}",
                    isActive = admin.active,
                    onDismiss = {
                        showDeactivateDialog = false
                    },
                    onConfirm = {
                        showDeactivateDialog = false
                        onDeactivateAdminClick()
                    }
                )
            }
        }

        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = dimens.screenPaddingHorizontal,
                        vertical = dimens.screenPaddingVertical
                    ),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(
                        R.string.company_dashboard_something_went_wrong
                    )
                )

                Button(
                    onClick = onRetry
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
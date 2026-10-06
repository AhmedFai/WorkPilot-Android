package com.faizan.workpilot.features.companyManagement.presentation.screen.companyStatus

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.component.AppTopBar
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.presentation.model.companyStatus.CompanyStatusUiState
import com.faizan.workpilot.features.companyManagement.presentation.screen.companyStatus.components.CompanyStatusActionCard
import com.faizan.workpilot.features.companyManagement.presentation.screen.companyStatus.components.CompanyStatusCard
import com.faizan.workpilot.features.companyManagement.presentation.screen.companyStatus.components.CompanyStatusCompanyCard
import com.faizan.workpilot.features.companyManagement.presentation.screen.companyStatus.components.CompanyStatusConfirmationDialog

@Composable
fun CompanyStatusScreen(
    uiState: CompanyStatusUiState,
    onBackClick: () -> Unit,
    onRetry: () -> Unit,
    onConfirmStatusChange: (Boolean) -> Unit
) {
    val dimens = MaterialTheme.dimens

    var showConfirmationDialog by remember {
        mutableStateOf(false)
    }

    if (showConfirmationDialog && uiState.companyInfo != null) {
        val company = uiState.companyInfo
        val isActive = company.active

        CompanyStatusConfirmationDialog(
            companyName = company.name,
            isActive = isActive,
            onDismiss = {
                if (!uiState.isUpdating) {
                    showConfirmationDialog = false
                }
            },
            onConfirm = {
                showConfirmationDialog = false
                onConfirmStatusChange(!isActive)
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {

        AppTopBar(
            title = stringResource(R.string.company_status_title),
            onBackClick = onBackClick,
            enabled = !uiState.isUpdating
        )

        when {
            uiState.isLoading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            uiState.companyInfo != null -> {
                val company = uiState.companyInfo
                val isActive = company.active

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(
                        start = dimens.screenPaddingHorizontal,
                        end = dimens.screenPaddingHorizontal,
                        top = dimens.spaceM,
                        bottom = dimens.spaceL
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        dimens.spaceM
                    )
                ) {

                    item {
                        CompanyStatusCompanyCard(
                            companyName = company.name
                        )
                    }

                    item {
                        Text(
                            text = stringResource(
                                R.string.company_status_current_status
                            ),
                            style = MaterialTheme.typography.titleSmall
                        )
                    }

                    item {
                        CompanyStatusCard(
                            isActive = isActive
                        )
                    }

                    item {
                        Text(
                            text = stringResource(
                                R.string.company_status_danger_zone
                            ),
                            style = MaterialTheme.typography.titleSmall,
                            color = Color(0xFFB91C1C)
                        )
                    }

                    item {
                        CompanyStatusActionCard(
                            isActive = isActive,
                            enabled = !uiState.isUpdating,
                            onClick = {
                                showConfirmationDialog = true
                            }
                        )
                    }
                }
            }

            else -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = dimens.screenPaddingHorizontal
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
}
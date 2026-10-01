package com.faizan.workpilot.features.companyManagement.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.presentation.model.CompanyDashboardUiState
import com.faizan.workpilot.features.companyManagement.presentation.screen.components.CompanyDashboardAdminPreview
import com.faizan.workpilot.features.companyManagement.presentation.screen.componenents.CompanyDashboardHeader
import com.faizan.workpilot.features.companyManagement.presentation.screen.componenents.CompanyDashboardRecentActivity
import com.faizan.workpilot.features.companyManagement.presentation.screen.componenents.CompanyDashboardStats
import com.faizan.workpilot.features.companyManagement.presentation.screen.componenents.CompanyDashboardTaskStatus
import com.faizan.workpilot.features.companyManagement.presentation.screen.shimmer.CompanyDashboardShimmer

@Composable
fun CompanyDashboardScreen(
    uiState: CompanyDashboardUiState,
    onBackClick: () -> Unit,
    onRetry: () -> Unit
) {

    val dimens = MaterialTheme.dimens

    when {

        uiState.isLoading -> {
            CompanyDashboardShimmer()
        }

        uiState.dashboard != null -> {

            val dashboard = uiState.dashboard

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .navigationBarsPadding()
                    .padding(
                        start = dimens.screenPaddingHorizontal,
                        top = dimens.screenPaddingVertical,
                        end = dimens.screenPaddingHorizontal
                    ),
                contentPadding = PaddingValues(
                    bottom = dimens.spaceS
                ),
                verticalArrangement =
                    Arrangement.spacedBy(dimens.spaceM)
            ) {

                item {
                    CompanyDashboardHeader(
                        company = dashboard.company,
                        onBackClick = onBackClick
                    )
                }

                item {
                    CompanyDashboardStats(
                        totalUsers = dashboard.totalUsers,
                        activeProjects = dashboard.activeProjects,
                        totalTasks = dashboard.totalTasks
                    )
                }

                item {
                    CompanyDashboardTaskStatus(
                        taskSummary = dashboard.taskSummary
                    )
                }

                item {
                    CompanyDashboardRecentActivity(
                        activities = dashboard.recentActivities.take(4)
                    )
                }

                item {
                    CompanyDashboardAdminPreview(
                        admins = dashboard.adminPreview.take(2)
                    )
                }
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
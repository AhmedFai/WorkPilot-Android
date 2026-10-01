package com.faizan.workpilot.features.companyManagement.presentation.screen.dashboard

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
import com.faizan.workpilot.features.companyManagement.presentation.model.dashboard.CompanyDashboardUiState
import com.faizan.workpilot.features.companyManagement.presentation.screen.components.CompanyDashboardAdminPreview
import com.faizan.workpilot.features.companyManagement.presentation.screen.dashboard.componenents.CompanyDashboardHeader
import com.faizan.workpilot.features.companyManagement.presentation.screen.dashboard.componenents.CompanyDashboardRecentActivity
import com.faizan.workpilot.features.companyManagement.presentation.screen.dashboard.componenents.CompanyDashboardStats
import com.faizan.workpilot.features.companyManagement.presentation.screen.dashboard.componenents.CompanyDashboardTaskStatus
import com.faizan.workpilot.features.companyManagement.presentation.screen.dashboard.shimmer.CompanyDashboardShimmer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.CompanyAdminsUiState
import com.faizan.workpilot.features.companyManagement.presentation.screen.dashboard.componenents.CompanyManagementTab
import com.faizan.workpilot.features.companyManagement.presentation.screen.admins.CompanyAdminsScreen

@Composable
fun CompanyDashboardScreen(
    uiState: CompanyDashboardUiState,
    adminsUiState: CompanyAdminsUiState,
    onBackClick: () -> Unit,
    onRetry: () -> Unit,
    onLoadAdmins: () -> Unit,
    onSearchQueryChange: (String) -> Unit,
    onLoadNextPage: () -> Unit,
    onAddAdminClick: () -> Unit,
    onAdminClick: (Long) -> Unit
) {

    val dimens = MaterialTheme.dimens

    var selectedTab by rememberSaveable {
        mutableStateOf(CompanyManagementTab.OVERVIEW)
    }

    when {

        uiState.isLoading -> {
            CompanyDashboardShimmer()
        }

        uiState.dashboard != null -> {

            val dashboard = uiState.dashboard

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .navigationBarsPadding()
            ) {

                CompanyDashboardHeader(
                    company = dashboard.company,
                    onBackClick = onBackClick,
                    selectedTab = selectedTab,
                    onTabSelected = { tab ->

                        selectedTab = tab

                        if (tab == CompanyManagementTab.ADMINS) {
                            onLoadAdmins()
                        }
                    }
                )

                when (selectedTab) {

                    CompanyManagementTab.OVERVIEW -> {

                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(
                                    horizontal = dimens.screenPaddingHorizontal
                                ),
                            contentPadding = PaddingValues(
                                top = dimens.spaceM,
                                bottom = dimens.spaceS
                            ),
                            verticalArrangement =
                                Arrangement.spacedBy(
                                    dimens.spaceM
                                )
                        ) {

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
                                    activities =
                                        dashboard.recentActivities.take(4)
                                )
                            }

                            item {
                                CompanyDashboardAdminPreview(
                                    admins =
                                        dashboard.adminPreview.take(2)
                                )
                            }
                        }
                    }

                    CompanyManagementTab.ADMINS -> {

                        CompanyAdminsScreen(
                            uiState = adminsUiState,
                            onAddAdminClick = onAddAdminClick,
                            onAdminClick = onAdminClick,
                            onSearchQueryChange = onSearchQueryChange
                        )
                    }

                    CompanyManagementTab.SETTINGS -> {

                        // Settings screen will be implemented later.
                    }
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
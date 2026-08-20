package com.faizan.workpilot.features.dashboard.admin.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.components.ErrorContent
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.dashboard.admin.presentation.model.DashboardAction
import com.faizan.workpilot.features.dashboard.admin.presentation.model.DashboardUiState
import com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.AdminDashboardShimmer

@Composable
fun AdminDashboardScreen(
    uiState: com.faizan.workpilot.features.dashboard.admin.presentation.model.DashboardUiState,
    onUsersClick: () -> Unit,
    onProjectsClick: () -> Unit,
    onTasksClick: () -> Unit,
    onReportsClick: () -> Unit,
    onProjectClick: (Long) -> Unit,
    onSearchClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .windowInsetsPadding(
                WindowInsets.safeDrawing
            )
    ) {

        when {
            uiState.isLoading -> {

                _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.AdminDashboardShimmer(
                    modifier = Modifier.fillMaxSize()
                )
            }

            uiState.error != null -> {

                ErrorContent(
                    error = uiState.error,
                    onRetry = onRetry,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(
                            Alignment.Center
                        )
                )
            }

            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(
                        horizontal = MaterialTheme.dimens.screenPaddingHorizontal,
                        vertical = MaterialTheme.dimens.spaceM
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        MaterialTheme.dimens.spaceM
                    )
                ) {

                    item {
                        _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.DashboardHeader(
                            greeting = uiState.greeting,
                            userName = uiState.userName,
                            onSearchClick = onSearchClick,
                            onProfileClick = onProfileClick,
                            onNotificationClick = onNotificationClick
                        )
                    }

                    item {
                        uiState.company?.let { company ->

                            _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.CompanyCard(
                                companyName = company.name,
                                email = company.email,
                                logoUrl = uiState.company.logoUrl,
                            )
                        }
                    }

                    item {
                        _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.DashboardStats(
                            employeeCount = uiState.employeeCount,
                            projectCount = uiState.projectCount,
                            taskCount = uiState.taskCount
                        )
                    }

                    item {
                        _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.SectionTitle(
                            title = stringResource(
                                R.string.dashboard_quick_actions
                            )
                        )
                    }

                    item {
                        _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.QuickActions(
                            onUsersClick = onUsersClick,
                            onProjectsClick = onProjectsClick,
                            onTasksClick = onTasksClick,
                            onReportsClick = onReportsClick
                        )
                    }

                    item {
                        _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.SectionTitle(
                            title = stringResource(
                                R.string.dashboard_recent_projects
                            )
                        )
                    }

                    items(
                        items = uiState.recentProjects,
                        key = { it.id }
                    ) { project ->

                        _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.RecentProjectCard(
                            project = project,
                            onClick = {
                                onProjectClick(project.id)
                            }
                        )
                    }
                }
            }
        }
    }
}
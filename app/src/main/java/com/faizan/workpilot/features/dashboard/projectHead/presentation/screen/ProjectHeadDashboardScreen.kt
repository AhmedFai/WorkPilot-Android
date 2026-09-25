package com.faizan.workpilot.features.dashboard.projectHead.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.ui.components.ErrorContent
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.dashboard.admin.presentation.screen.DashboardHeader
import com.faizan.workpilot.features.dashboard.projectHead.presentation.model.ProjectHeadDashboardUiState
import com.faizan.workpilot.features.dashboard.projectHead.presentation.screen.shimmer.ProjectHeadDashboardShimmer

@Composable
fun ProjectHeadDashboardScreen(
    uiState: ProjectHeadDashboardUiState,
    onSearchClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onProjectClick: (Long) -> Unit,
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
                ProjectHeadDashboardShimmer(
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
                        horizontal = MaterialTheme
                            .dimens
                            .screenPaddingHorizontal,
                        vertical = MaterialTheme
                            .dimens
                            .spaceM
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        MaterialTheme.dimens.spaceM
                    )
                ) {

                    item {
                        DashboardHeader(
                            greeting = uiState.greeting,
                            userName = uiState.userName,
                            onSearchClick = onSearchClick,
                            onProfileClick = onProfileClick,
                            onNotificationClick =
                                onNotificationClick
                        )
                    }

                    item {
                        ProjectHeadStats(
                            currentProjectCount =
                                uiState.currentProjectCount,
                            taskCount = uiState.taskCount,
                            overdueTaskCount =
                                uiState.overdueTaskCount
                        )
                    }

                    items(
                        items = uiState.projects,
                        key = { project ->
                            project.id
                        }
                    ) { project ->

                        ProjectHeadProjectCard(
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
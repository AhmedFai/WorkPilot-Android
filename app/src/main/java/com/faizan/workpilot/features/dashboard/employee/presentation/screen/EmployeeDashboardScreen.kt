package com.faizan.workpilot.features.dashboard.employee.presentation.screen

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
import com.faizan.workpilot.features.dashboard.employee.presentation.model.EmployeeDashboardUiState
import com.faizan.workpilot.features.dashboard.employee.presentation.screen.shimmer.EmployeeDashboardShimmer

@Composable
fun EmployeeDashboardScreen(
    uiState: EmployeeDashboardUiState,
    onSearchClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNotification: () -> Unit,
    onSortClick: () -> Unit,
    onTaskClick: (Long) -> Unit,
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

                EmployeeDashboardShimmer(
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
                        horizontal =
                            MaterialTheme.dimens
                                .screenPaddingHorizontal,
                        vertical =
                            MaterialTheme.dimens.spaceM
                    ),
                    verticalArrangement =
                        Arrangement.spacedBy(
                            MaterialTheme.dimens.spaceM
                        )
                ) {

                    item {

                        DashboardHeader(
                            greeting = uiState.greeting,
                            userName = uiState.userName,
                            onSearchClick = onSearchClick,
                            onProfileClick = onProfileClick,
                            onNotificationClick = onNotification
                        )
                    }

                    item {

                        EmployeeTaskStats(
                            myTaskCount =
                                uiState.myTaskCount,
                            completedTaskCount =
                                uiState.completedTaskCount,
                            pendingTaskCount =
                                uiState.pendingTaskCount
                        )
                    }

                    item {

                        EmployeeTodayTasksHeader(
                            onSortClick = onSortClick
                        )
                    }

                    items(
                        items = uiState.todayTasks,
                        key = { task ->
                            task.id
                        }
                    ) { task ->

                        EmployeeTaskCard(
                            task = task,
                            onClick = {
                                onTaskClick(task.id)
                            }
                        )
                    }
                }
            }
        }
    }
}
package com.faizan.workpilot.features.dashboard.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Analytics
import androidx.compose.material.icons.rounded.Groups
import androidx.compose.material.icons.rounded.TaskAlt
import androidx.compose.material.icons.rounded.Workspaces
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.dashboard.presentation.model.DashboardAction
import com.faizan.workpilot.features.dashboard.presentation.model.DashboardQuickAction

@Composable
fun QuickActions(
    onUsersClick: () -> Unit,
    onProjectsClick: () -> Unit,
    onTasksClick: () -> Unit,
    onReportsClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceXS
        )
    ) {

        QuickActionItem(
            title = stringResource(
                R.string.dashboard_users
            ),
            icon = Icons.Rounded.Groups,
            modifier = Modifier.weight(1f),
            onClick = onUsersClick
        )

        QuickActionItem(
            title = stringResource(
                R.string.dashboard_projects
            ),
            icon = Icons.Rounded.Workspaces,
            modifier = Modifier.weight(1f),
            onClick = onProjectsClick
        )

        QuickActionItem(
            title = stringResource(
                R.string.dashboard_tasks
            ),
            icon = Icons.Rounded.TaskAlt,
            modifier = Modifier.weight(1f),
            onClick = onTasksClick
        )

        QuickActionItem(
            title = stringResource(
                R.string.dashboard_reports
            ),
            icon = Icons.Rounded.Analytics,
            modifier = Modifier.weight(1f),
            onClick = onReportsClick
        )
    }
}
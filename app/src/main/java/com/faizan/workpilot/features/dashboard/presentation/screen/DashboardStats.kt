package com.faizan.workpilot.features.dashboard.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun DashboardStats(
    employeeCount: Int,
    projectCount: Int,
    taskCount: Int,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceS
        )
    ) {

        DashboardStatCard(
            title = "Employees",
            value = employeeCount,
            modifier = Modifier.weight(1f)
        )

        DashboardStatCard(
            title = "Projects",
            value = projectCount,
            modifier = Modifier.weight(1f)
        )

        DashboardStatCard(
            title = "Tasks",
            value = taskCount,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun DashboardStatCard(
    title: String,
    value: Int,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surfaceVariant
        )
    ) {

        androidx.compose.foundation.layout.Column(
            modifier = Modifier.padding(
                MaterialTheme.dimens.spaceM
            )
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = value.toString(),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
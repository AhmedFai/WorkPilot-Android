package com.faizan.workpilot.features.dashboard.employee.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun EmployeeTaskStats(
    myTaskCount: Long,
    completedTaskCount: Long,
    pendingTaskCount: Long,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceXS
        )
    ) {

        EmployeeStatCard(
            title = "My Tasks",
            count = myTaskCount,
            subtitle = "Total",
            modifier = Modifier.weight(1f)
        )

        EmployeeStatCard(
            title = "Completed",
            count = completedTaskCount,
            subtitle = "Today",
            modifier = Modifier.weight(1f)
        )

        EmployeeStatCard(
            title = "Pending",
            count = pendingTaskCount,
            subtitle = "Today",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun EmployeeStatCard(
    title: String,
    count: Long,
    subtitle: String,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(
            MaterialTheme.dimens.radiusM
        ),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surfaceVariant
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    MaterialTheme.dimens.spaceS
                ),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.labelMedium
            )

            Text(
                text = count.toString(),
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = subtitle,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
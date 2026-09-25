package com.faizan.workpilot.features.dashboard.projectHead.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun ProjectHeadStats(
    currentProjectCount: Long,
    taskCount: Long,
    overdueTaskCount: Long,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement =
            Arrangement.spacedBy(
                MaterialTheme.dimens.spaceXS
            )
    ) {

        ProjectHeadStatCard(
            title = "Current Projects",
            count = currentProjectCount,
            modifier = Modifier.weight(1f)
        )

        ProjectHeadStatCard(
            title = "Tasks",
            count = taskCount,
            modifier = Modifier.weight(1f)
        )

        ProjectHeadStatCard(
            title = "Overdue",
            count = overdueTaskCount,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun ProjectHeadStatCard(
    title: String,
    count: Long,
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
            horizontalAlignment =
                Alignment.Start
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.labelMedium
            )

            Text(
                text = count.toString(),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}
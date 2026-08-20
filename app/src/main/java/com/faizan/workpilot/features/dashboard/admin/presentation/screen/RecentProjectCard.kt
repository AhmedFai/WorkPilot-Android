package com.faizan.workpilot.features.dashboard.admin.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.dashboard.admin.presentation.model.RecentProjectUiModel

@Composable
fun RecentProjectCard(
    project: com.faizan.workpilot.features.dashboard.admin.presentation.model.RecentProjectUiModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surface
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    MaterialTheme.dimens.spaceM
                ),
            horizontalArrangement = Arrangement.spacedBy(
                MaterialTheme.dimens.spaceM
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.ProjectIcon()

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = project.name,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = project.statusLabel,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.ProjectStatusBadge(
                status = project.status
            )
        }
    }
}
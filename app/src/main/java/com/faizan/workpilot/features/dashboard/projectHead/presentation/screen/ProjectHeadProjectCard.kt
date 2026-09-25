package com.faizan.workpilot.features.dashboard.projectHead.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.shape.RoundedCornerShape
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.dashboard.projectHead.domain.model.ProjectHeadProject

@Composable
fun ProjectHeadProjectCard(
    project: ProjectHeadProject,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(
            MaterialTheme.dimens.radiusM
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.dimens.spaceM)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = project.name,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(
                    modifier = Modifier.width(
                        MaterialTheme.dimens.spaceS
                    )
                )

                Text(
                    text = "${project.progress}%",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(
                modifier = Modifier.width(
                    MaterialTheme.dimens.spaceS
                )
            )

            LinearProgressIndicator(
                progress = {
                    project.progress.coerceIn(0, 100) / 100f
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
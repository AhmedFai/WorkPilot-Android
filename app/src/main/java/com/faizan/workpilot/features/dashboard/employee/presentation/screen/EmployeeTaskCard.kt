package com.faizan.workpilot.features.dashboard.employee.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.shape.RoundedCornerShape
import com.faizan.workpilot.core.common.domain.model.Priority
import com.faizan.workpilot.core.common.domain.model.Status
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.dashboard.employee.domain.model.EmployeeTodayTask

@Composable
fun EmployeeTaskCard(
    task: EmployeeTodayTask,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(
            MaterialTheme.dimens.radiusM
        ),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = MaterialTheme.dimens.elevationS
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    MaterialTheme.dimens.spaceM
                ),
            horizontalArrangement =
                Arrangement.spacedBy(
                    MaterialTheme.dimens.spaceS
                ),
            verticalAlignment = Alignment.Top
        ) {

            TaskStatusIndicator(
                status = task.status
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement =
                    Arrangement.spacedBy(
                        MaterialTheme.dimens.spaceXS
                    )
            ) {

                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = task.project.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )

                Row(
                    horizontalArrangement =
                        Arrangement.spacedBy(
                            MaterialTheme.dimens.spaceS
                        ),
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    TaskPriorityText(
                        priority = task.priority
                    )

                    Icon(
                        imageVector = Icons.Default.AccessTime,
                        contentDescription = null,
                        modifier = Modifier.size(
                            MaterialTheme.dimens.iconXS
                        ),
                        tint =
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Text(
                        text = task.deadline,
                        style = MaterialTheme.typography.labelSmall,
                        color =
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun TaskStatusIndicator(
    status: Status
) {

    val indicatorColor =
        when (status) {
            Status.PENDING -> MaterialTheme.colorScheme.error
            Status.IN_PROGRESS -> MaterialTheme.colorScheme.primary
            Status.COMPLETED -> MaterialTheme.colorScheme.tertiary
            Status.APPROVED -> MaterialTheme.colorScheme.secondary
            Status.REOPEN -> MaterialTheme.colorScheme.error
        }

    Surface(
        modifier = Modifier.size(
            MaterialTheme.dimens.iconS
        ),
        shape = RoundedCornerShape(
            MaterialTheme.dimens.radiusS
        ),
        color = indicatorColor.copy(alpha = 0.12f)
    ) {
        // Intentionally empty.
        // The colored surface itself acts as the status indicator.
    }
}

@Composable
private fun TaskPriorityText(
    priority: Priority
) {

    val text =
        when (priority) {
            Priority.LOW -> "Low"
            Priority.MEDIUM -> "Medium"
            Priority.HIGH -> "High"
        }

    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.primary
    )
}
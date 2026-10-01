package com.faizan.workpilot.features.companyManagement.presentation.screen.componenents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.HourglassEmpty
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.domain.model.CompanyTaskSummary

@Composable
fun CompanyDashboardTaskStatus(
    taskSummary: CompanyTaskSummary
) {

    val dimens = MaterialTheme.dimens

    Column(
        verticalArrangement =
            Arrangement.spacedBy(dimens.spaceS)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =
                Arrangement.SpaceBetween
        ) {

            Text(
                text = stringResource(
                    R.string.company_dashboard_task_status
                ),
                style =
                    MaterialTheme.typography.titleMedium
            )

            Text(
                text = stringResource(
                    R.string.company_dashboard_last_30_days
                ),
                style =
                    MaterialTheme.typography.labelMedium,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =
                Arrangement.spacedBy(dimens.spaceXS)
        ) {

            TaskStatusCard(
                title = stringResource(
                    R.string.company_dashboard_pending_label
                ),
                value = taskSummary.pending.toString(),
                icon = {
                    Icon(
                        imageVector =
                            Icons.Default.HourglassEmpty,
                        contentDescription = null,
                        tint = Color(0xFFFF8A00)
                    )
                },
                modifier = Modifier.weight(1f),
                containerColor = Color(0xFFFFF7EC),
                titleColor = Color(0xFF5F5A55)
            )

            TaskStatusCard(
                title = stringResource(
                    R.string.company_dashboard_in_progress_label
                ),
                value = taskSummary.inProgress.toString(),
                icon = {
                    Icon(
                        imageVector =
                            Icons.Default.Refresh,
                        contentDescription = null,
                        tint = Color(0xFF145EFF)
                    )
                },
                modifier = Modifier.weight(1f),
                containerColor = Color(0xFFEEF4FF),
                titleColor = Color(0xFF145EFF)
            )

            TaskStatusCard(
                title = stringResource(
                    R.string.company_dashboard_completed_label
                ),
                value = taskSummary.completed.toString(),
                icon = {
                    Icon(
                        imageVector =
                            Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Color(0xFF13B66A)
                    )
                },
                modifier = Modifier.weight(1f),
                containerColor = Color(0xFFEDF9F2),
                titleColor = Color(0xFF198754)
            )

            TaskStatusCard(
                title = stringResource(
                    R.string.company_dashboard_overdue_label
                ),
                value = taskSummary.overdue.toString(),
                icon = {
                    Icon(
                        imageVector =
                            Icons.Default.Error,
                        contentDescription = null,
                        tint = Color(0xFFFF2525)
                    )
                },
                modifier = Modifier.weight(1f),
                containerColor = Color(0xFFFFEEEE),
                titleColor = Color(0xFFE31B1B)
            )
        }
    }
}

@Composable
private fun TaskStatusCard(
    title: String,
    value: String,
    icon: @Composable () -> Unit,
    containerColor: Color,
    titleColor: Color,
    modifier: Modifier = Modifier
) {

    val dimens = MaterialTheme.dimens

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
        shape = MaterialTheme.shapes.medium
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.spaceS),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement =
                Arrangement.spacedBy(dimens.spaceXS)
        ) {

            icon()

            Text(
                text = title,
                style =
                    MaterialTheme.typography.labelSmall,
                color = titleColor
            )

            Text(
                text = value,
                style =
                    MaterialTheme.typography.titleLarge,
                color =
                    MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
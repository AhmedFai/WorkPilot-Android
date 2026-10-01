package com.faizan.workpilot.features.companyManagement.presentation.screen.dashboard.componenents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.domain.model.dashboard.CompanyActivityPreview
import com.faizan.workpilot.features.companyManagement.presentation.model.dashboard.getCompanyActivityUi

@Composable
fun CompanyDashboardRecentActivity(
    activities: List<CompanyActivityPreview>
) {

    val dimens = MaterialTheme.dimens

    Column(
        verticalArrangement = Arrangement.spacedBy(
            dimens.spaceS
        )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = stringResource(
                    R.string.company_dashboard_recent_activity
                ),
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = stringResource(
                    R.string.company_dashboard_view_all
                ),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = dimens.elevationS
            ),
            shape = MaterialTheme.shapes.medium
        ) {

            Column {

                activities.forEachIndexed { index, activity ->

                    CompanyActivityRow(
                        activity = activity
                    )

                    if (index < activities.lastIndex) {

                        HorizontalDivider(
                            modifier = Modifier.padding(
                                horizontal = dimens.spaceM
                            ),
                            color =
                                MaterialTheme.colorScheme.outlineVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CompanyActivityRow(
    activity: CompanyActivityPreview
) {

    val dimens = MaterialTheme.dimens

    val activityUi = getCompanyActivityUi(
        type = activity.type,
        createdAt = activity.createdAt
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimens.spaceM,
                vertical = dimens.spaceS
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            dimens.spaceS
        )
    ) {

        Surface(
            shape = MaterialTheme.shapes.small,
            color = activityUi.iconBackgroundColor
        ) {

            Icon(
                imageVector = activityUi.icon,
                contentDescription = null,
                tint = activityUi.iconColor,
                modifier = Modifier.padding(
                    dimens.spaceS
                )
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                dimens.space2XS
            )
        ) {

            Text(
                text = activity.message,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = activity.performedBy,
                style = MaterialTheme.typography.labelSmall,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )

            activity.description?.let { description ->

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color =
                        MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        if (activityUi.relativeTime.isNotBlank()) {

            Text(
                text = activityUi.relativeTime,
                style = MaterialTheme.typography.labelSmall,
                color =
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
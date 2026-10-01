package com.faizan.workpilot.features.companyManagement.presentation.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.domain.model.CompanyAdminPreview

@Composable
fun CompanyDashboardAdminPreview(
    admins: List<CompanyAdminPreview>
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
                    R.string.company_dashboard_admins
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

                admins.forEachIndexed { index, admin ->

                    CompanyAdminRow(
                        admin = admin
                    )

                    if (index < admins.lastIndex) {
                        HorizontalDivider(
                            modifier = Modifier.padding(
                                horizontal = dimens.spaceM
                            ),
                            color = MaterialTheme.colorScheme.outlineVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CompanyAdminRow(
    admin: CompanyAdminPreview
) {

    val dimens = MaterialTheme.dimens

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
            color = MaterialTheme.colorScheme.primaryContainer
        ) {

            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
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
                text = "${admin.firstName} ${admin.lastName}",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = admin.email,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Surface(
            shape = MaterialTheme.shapes.small,
            color = if (admin.active) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.surfaceVariant
            }
        ) {

            Text(
                text = stringResource(
                    if (admin.active) {
                        R.string.company_dashboard_active
                    } else {
                        R.string.company_dashboard_inactive
                    }
                ),
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(
                    horizontal = dimens.spaceS,
                    vertical = dimens.spaceXS
                )
            )
        }
    }
}
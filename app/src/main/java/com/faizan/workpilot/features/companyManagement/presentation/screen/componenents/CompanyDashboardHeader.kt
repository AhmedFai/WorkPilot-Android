package com.faizan.workpilot.features.companyManagement.presentation.screen.componenents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.domain.model.CompanyOverviewCompany

@Composable
fun CompanyDashboardHeader(
    company: CompanyOverviewCompany,
    onBackClick: () -> Unit
) {

    val dimens = MaterialTheme.dimens

    Column(
        verticalArrangement =
            Arrangement.spacedBy(dimens.spaceXS)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = onBackClick
            ) {
                Icon(
                    imageVector =
                        Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription =
                        stringResource(
                            R.string.common_back
                        )
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        horizontal = dimens.spaceXS
                    )
            ) {

                Text(
                    text = company.name,
                    style =
                        MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = stringResource(
                        R.string.company_dashboard_overview
                    ),
                    style =
                        MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Surface(
                shape = MaterialTheme.shapes.small,
                color = if (company.active) {
                    MaterialTheme.colorScheme.primaryContainer
                } else {
                    MaterialTheme.colorScheme.surfaceVariant
                }
            ) {

                Text(
                    text = stringResource(
                        if (company.active) {
                            R.string.company_dashboard_active
                        } else {
                            R.string.company_dashboard_inactive
                        }
                    ),
                    style =
                        MaterialTheme.typography.labelMedium,
                    maxLines = 1,
                    modifier = Modifier.padding(
                        horizontal = dimens.spaceS,
                        vertical = dimens.spaceXS
                    )
                )
            }

            IconButton(
                onClick = {
                    // Reserved for company actions.
                }
            ) {
                Icon(
                    imageVector =
                        Icons.Default.MoreVert,
                    contentDescription = null
                )
            }
        }

        CompanyDashboardTabs()
    }
}
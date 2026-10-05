package com.faizan.workpilot.features.companyManagement.presentation.screen.companyInfo.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo

@Composable
fun CompanyInfoSummaryCard(
    company: CompanyInfo
) {
    val dimens = MaterialTheme.dimens

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimens.screenPaddingHorizontal
            ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimens.elevationS
        ),
        shape = RoundedCornerShape(
            dimens.radiusM
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.spaceM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                dimens.spaceS
            )
        ) {
            Surface(
                modifier = Modifier.size(dimens.iconXL),
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Icon(
                    imageVector = Icons.Default.Business,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(dimens.spaceS)
                )
            }

            androidx.compose.foundation.layout.Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    dimens.space2XS
                )
            ) {
                Text(
                    text = company.name,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = stringResource(
                        R.string.company_information_company_details
                    ),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
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
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(
                        horizontal = dimens.spaceS,
                        vertical = dimens.spaceXS
                    )
                )
            }
        }
    }
}
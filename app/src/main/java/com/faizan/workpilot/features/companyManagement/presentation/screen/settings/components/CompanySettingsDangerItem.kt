package com.faizan.workpilot.features.companyManagement.presentation.screen.settings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Delete
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

@Composable
fun CompanySettingsDangerItem(
    onClick: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFEBEE)
        ),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimens.space2XS
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.spaceS),
            verticalAlignment = Alignment.CenterVertically
        ) {

            SettingsIconContainer(
                iconType = CompanySettingsIcon.DELETE
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        start = dimens.spaceS,
                        end = dimens.spaceS
                    ),
                verticalArrangement = Arrangement.spacedBy(
                    dimens.space2XS
                )
            ) {
                Text(
                    text = stringResource(
                        R.string.company_settings_deactivate_company
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFD32F2F)
                )

                Text(
                    text = stringResource(
                        R.string.company_settings_deactivate_description
                    ),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(dimens.iconS)
            )
        }
    }
}
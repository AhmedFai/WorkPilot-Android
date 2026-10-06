package com.faizan.workpilot.features.companyManagement.presentation.screen.settings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PowerSettingsNew
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
import com.faizan.workpilot.features.companyManagement.presentation.screen.companyStatus.components.CompanyStatusStyles

@Composable
fun CompanySettingsDangerItem(
    companyActive: Boolean,
    onClick: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    val style = if (companyActive) {
        CompanyStatusStyles.inactive
    } else {
        CompanyStatusStyles.active
    }

    val titleRes = if (companyActive) {
        R.string.company_settings_deactivate_company
    } else {
        R.string.company_status_activate
    }

    val descriptionRes = if (companyActive) {
        R.string.company_settings_deactivate_description
    } else {
        R.string.company_status_activate_description
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = style.containerColor
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

            Surface(
                modifier = Modifier.size(dimens.iconL),
                shape = RoundedCornerShape(dimens.radiusS),
                color = style.iconBackgroundColor
            ) {
                Icon(
                    imageVector = Icons.Default.PowerSettingsNew,
                    contentDescription = null,
                    tint = style.iconColor,
                    modifier = Modifier.padding(dimens.spaceXS)
                )
            }

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
                    text = stringResource(titleRes),
                    style = MaterialTheme.typography.bodyMedium,
                    color = style.titleColor
                )

                Text(
                    text = stringResource(descriptionRes),
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
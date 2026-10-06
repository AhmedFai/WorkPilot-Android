package com.faizan.workpilot.features.companyManagement.presentation.screen.companyStatus.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun CompanyStatusCard(
    isActive: Boolean
) {
    val dimens = MaterialTheme.dimens

    val title = if (isActive) {
        stringResource(R.string.company_status_active)
    } else {
        stringResource(R.string.company_status_inactive)
    }

    val description = if (isActive) {
        stringResource(
            R.string.company_status_active_description
        )
    } else {
        stringResource(
            R.string.company_status_inactive_description
        )
    }

    val style = if (isActive) {
        CompanyStatusStyles.active
    } else {
        CompanyStatusStyles.inactive
    }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimens.radiusM),
        color = style.containerColor
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.spaceM),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                modifier = Modifier.size(40.dp),
                shape = CircleShape,
                color = style.iconBackgroundColor
            ) {
                Icon(
                    imageVector = if (isActive) {
                        Icons.Default.Check
                    } else {
                        Icons.Default.PowerSettingsNew
                    },
                    contentDescription = null,
                    tint = style.iconColor,
                    modifier = Modifier.padding(9.dp)
                )
            }

            Spacer(
                modifier = Modifier.width(dimens.spaceM)
            )

            androidx.compose.foundation.layout.Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    color = style.titleColor
                )
                Spacer(modifier = Modifier.padding(top = dimens.spaceXS))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
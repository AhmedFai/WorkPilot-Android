
package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminDetails

@Composable
fun AdminAccountStatusCard(
    admin: CompanyAdminDetails
) {
    val dimens = MaterialTheme.dimens

    val statusColor = if (admin.active) {
        Color(0xFF16A34A)
    } else {
        MaterialTheme.colorScheme.error
    }

    val backgroundColor = if (admin.active) {
        Color(0xFFE8F8EC)
    } else {
        MaterialTheme.colorScheme.errorContainer
    }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimens.radiusM),
        color = backgroundColor
    ) {
        Column(
            modifier = Modifier.padding(dimens.spaceM),
            verticalArrangement = Arrangement.spacedBy(dimens.spaceXS)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(dimens.spaceXS)
            ) {
                Icon(
                    imageVector = if (admin.active) {
                        Icons.Default.CheckCircle
                    } else {
                        Icons.Default.Cancel
                    },
                    contentDescription = null,
                    modifier = Modifier.size(dimens.iconXS),
                    tint = statusColor
                )

                Text(
                    text = stringResource(R.string.admin_account_status_title),
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = stringResource(
                        if (admin.active) {
                            R.string.admin_status_active
                        } else {
                            R.string.admin_status_inactive
                        }
                    ),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = statusColor
                )
            }

            Text(
                text = stringResource(
                    if (admin.active) {
                        R.string.admin_account_active_description
                    } else {
                        R.string.admin_account_inactive_description
                    }
                ),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

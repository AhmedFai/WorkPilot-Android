
package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
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
fun AdminProfileCard(
    admin: CompanyAdminDetails
) {
    val dimens = MaterialTheme.dimens

    val activeGreen = Color(0xFF16A34A)
    val activeBackground = Color(0xFFDDF7E8)

    Surface(
        modifier = Modifier,
        shape = RoundedCornerShape(dimens.radiusL),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row(
            modifier = Modifier.padding(dimens.spaceM),
            horizontalArrangement = Arrangement.spacedBy(dimens.spaceM),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(dimens.avatarL),
                shape = RoundedCornerShape(dimens.radiusM),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(dimens.iconL),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(dimens.space2XS)
            ) {
                Text(
                    text = "${admin.firstName} ${admin.lastName}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = admin.email,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Surface(
                    shape = RoundedCornerShape(dimens.radiusXL),
                    color = if (admin.active) activeBackground
                    else MaterialTheme.colorScheme.errorContainer
                ) {
                    Row(
                        modifier = Modifier.padding(
                            horizontal = dimens.spaceXS,
                            vertical = dimens.space2XS
                        ),
                        horizontalArrangement = Arrangement.spacedBy(dimens.space2XS),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(dimens.indicatorSize)
                                .background(
                                    if (admin.active) activeGreen
                                    else MaterialTheme.colorScheme.error,
                                    CircleShape
                                )
                        )

                        Text(
                            text = stringResource(
                                if (admin.active) R.string.admin_status_active
                                else R.string.admin_status_inactive
                            ),
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = if (admin.active) activeGreen
                            else MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
    }
}


package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Badge
import androidx.compose.material.icons.outlined.Business
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material3.HorizontalDivider
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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun AdminInformationCard(
    admin: CompanyAdminDetails
) {
    val dimens = MaterialTheme.dimens

    Column(
        verticalArrangement = Arrangement.spacedBy(dimens.spaceXS)
    ) {
        Text(
            text = stringResource(R.string.admin_information_title),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(dimens.radiusM),
            color = Color.White,
            shadowElevation = dimens.elevationS
        ) {
            Column(
                modifier = Modifier.padding(
                    horizontal = dimens.spaceM,
                    vertical = dimens.spaceXS
                )
            ) {
                AdminInformationRow(
                    icon = {
                        Icon(Icons.Outlined.Badge, contentDescription = null)
                    },
                    label = stringResource(R.string.admin_role_label),
                    value = admin.role,
                    isRole = true
                )

                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                AdminInformationRow(
                    icon = {
                        Icon(Icons.Outlined.Business, contentDescription = null)
                    },
                    label = stringResource(R.string.admin_company_label),
                    value = admin.companyName
                )

                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                AdminInformationRow(
                    icon = {
                        Icon(Icons.Outlined.CalendarToday, contentDescription = null)
                    },
                    label = stringResource(R.string.admin_created_on_label),
                    value = formatAdminDate(admin.createdAt)
                )

                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                AdminInformationRow(
                    icon = {
                        Icon(Icons.Outlined.CalendarToday, contentDescription = null)
                    },
                    label = stringResource(R.string.admin_updated_on_label),
                    value = formatAdminDate(admin.updatedAt)
                )
            }
        }
    }
}

@Composable
private fun AdminInformationRow(
    icon: @Composable () -> Unit,
    label: String,
    value: String,
    isRole: Boolean = false
) {
    val dimens = MaterialTheme.dimens

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = dimens.spaceS),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimens.spaceS)
    ) {
        androidx.compose.ui.layout.Layout(
            content = icon
        ) { measurables, constraints ->
            val placeable = measurables.first().measure(constraints)
            layout(placeable.width, placeable.height) {
                placeable.placeRelative(0, 0)
            }
        }

        Text(
            text = label,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = value,
            style = if (isRole) {
                MaterialTheme.typography.labelMedium
            } else {
                MaterialTheme.typography.bodySmall
            },
            fontWeight = if (isRole) FontWeight.SemiBold else FontWeight.Normal,
            color = if (isRole) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface
            }
        )
    }
}

private fun formatAdminDate(value: String): String {
    return runCatching {
        val date = LocalDateTime.parse(value)
        date.format(
            DateTimeFormatter.ofPattern(
                "dd MMM yyyy, hh:mm a",
                Locale.ENGLISH
            )
        )
    }.getOrDefault(value)
}

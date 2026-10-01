package com.faizan.workpilot.features.companyManagement.presentation.screen.admins.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
// import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
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
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdmin
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun CompanyAdminListItem(
    admin: CompanyAdmin,
    onClick: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    val createdAt = formatCreatedAt(admin.createdAt)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimens.space2XS
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimens.spaceS,
                    vertical = dimens.spaceS
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Avatar
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

            // Admin information
            // Admin information
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

                // Name + Status
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "${admin.firstName} ${admin.lastName}",
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                        modifier = Modifier.weight(1f)
                    )

                    Box(
                        modifier = Modifier.size(dimens.spaceS),
                        contentAlignment = Alignment.Center
                    ) {
                        Surface(
                            modifier = Modifier.size(dimens.spaceXS),
                            shape = MaterialTheme.shapes.small,
                            color = if (admin.active) {
                                Color.Green
                            } else {
                                Color.Red
                            }
                        ) {}
                    }
                }

                Text(
                    text = admin.email,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        dimens.space2XS
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.CalendarToday,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(
                            dimens.iconXS
                        )
                    )

                    Text(
                        text = stringResource(
                            R.string.company_admin_created_at,
                            createdAt
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1
                    )
                }
            }

            /*
            // Three dots - temporarily disabled

            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
                modifier = Modifier.clickable(
                    onClick = onClick
                )
            )
            */
        }
    }
}

private fun formatCreatedAt(value: String): String {
    return try {
        val dateTime = LocalDateTime.parse(
            value,
            DateTimeFormatter.ISO_LOCAL_DATE_TIME
        )

        dateTime.format(
            DateTimeFormatter.ofPattern(
                "dd MMM yyyy, hh:mm a",
                Locale.ENGLISH
            )
        )
    } catch (_: Exception) {
        value
    }
}
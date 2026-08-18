package com.faizan.workpilot.features.dashboard.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun DashboardHeader(
    greeting: UiText,
    userName: String,
    onSearchClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNotificationClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceS
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        androidx.compose.foundation.layout.Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = greeting.asString(context),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = userName,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        IconButton(
            onClick = onSearchClick
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(
                    R.string.dashboard_search
                )
            )
        }

        IconButton(
            onClick = onNotificationClick
        ) {
            Icon(
                imageVector = Icons.Default.NotificationsNone,
                contentDescription = stringResource(
                    R.string.dashboard_notifications
                )
            )
        }

        Surface(
            modifier = Modifier.size(
                MaterialTheme.dimens.avatarS
            ),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer,
            onClick = onProfileClick
        ) {

            androidx.compose.foundation.layout.Box(
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = stringResource(
                        R.string.dashboard_profile
                    ),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}
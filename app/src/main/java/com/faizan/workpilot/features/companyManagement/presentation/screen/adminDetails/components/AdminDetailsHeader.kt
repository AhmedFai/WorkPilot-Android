
package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDetailsHeader(
    onBackClick: () -> Unit,
    onEditAdminClick: () -> Unit,
    onViewActivityClick: () -> Unit
) {
    val dimens = MaterialTheme.dimens
    val colors = MaterialTheme.colorScheme

    var menuExpanded by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        title = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.admin_details_title),
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = stringResource(R.string.admin_details_subtitle),
                    style = MaterialTheme.typography.bodySmall,
                    color = colors.onSurfaceVariant
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back)
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    menuExpanded = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.more_options)
                )
            }

            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = {
                    menuExpanded = false
                },
                shape = RoundedCornerShape(dimens.radiusL),
                containerColor = colors.surface,
                tonalElevation = dimens.elevationS,
                shadowElevation = dimens.elevationL,
                modifier = Modifier
                    .clip(RoundedCornerShape(dimens.radiusL))
            ) {

                // Edit Admin - Highlighted item
                DropdownMenuItem(
                    text = {
                        Text(
                            text = stringResource(R.string.admin_edit_title),
                            style = MaterialTheme.typography.labelLarge
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null,
                            tint = colors.primary
                        )
                    },
                    onClick = {
                        menuExpanded = false
                        onEditAdminClick()
                    },
                    modifier = Modifier
                        .padding(horizontal = dimens.spaceXS)
                        .clip(RoundedCornerShape(dimens.radiusM))
                        .background(colors.primaryContainer),
                    colors = MenuDefaults.itemColors(
                        textColor = colors.onPrimaryContainer,
                        leadingIconColor = colors.primary
                    )
                )

                // View Activity
                DropdownMenuItem(
                    text = {
                        Text(
                            text = stringResource(R.string.admin_view_activity),
                            style = MaterialTheme.typography.labelLarge
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.History,
                            contentDescription = null,
                            tint = colors.onSurfaceVariant
                        )
                    },
                    onClick = {
                        menuExpanded = false
                        onViewActivityClick()
                    },
                    modifier = Modifier.padding(
                        horizontal = dimens.spaceXS
                    ),
                    colors = MenuDefaults.itemColors(
                        textColor = colors.onSurface,
                        leadingIconColor = colors.onSurfaceVariant
                    )
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colors.background
        )
    )
}

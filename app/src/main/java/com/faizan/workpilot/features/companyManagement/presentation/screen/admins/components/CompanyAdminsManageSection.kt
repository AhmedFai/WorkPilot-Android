package com.faizan.workpilot.features.companyManagement.presentation.screen.admins.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun CompanyAdminsManageSection(
    onAddAdminClick: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = dimens.spaceL,
                bottom = dimens.spaceM
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            dimens.spaceS
        )
    ) {

        Icon(
            imageVector = Icons.Default.AdminPanelSettings,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .size(dimens.space2XL)
        )

        Text(
            text = stringResource(
                R.string.company_admins_manage_title
            ),
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = stringResource(
                R.string.company_admins_manage_description
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimens.screenPaddingHorizontal
                ),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Button(
            onClick = onAddAdminClick
        ) {
            Text(
                text = stringResource(
                    R.string.company_admins_add_admin
                )
            )
        }
    }
}
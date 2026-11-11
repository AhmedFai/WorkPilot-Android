
package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun CompanyAdminFormHeader(
    isEditMode: Boolean,
    modifier: Modifier = Modifier
) {
    val dimens = MaterialTheme.dimens

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimens.spaceS)
    ) {
        Surface(
            modifier = Modifier.size(dimens.iconXL),
            shape = RoundedCornerShape(dimens.radiusM),
            color = MaterialTheme.colorScheme.background
        ) {
            Icon(
                imageVector = if (isEditMode) {
                    Icons.Default.Edit
                } else {
                    Icons.Default.PersonAdd
                },
                contentDescription = null,
                modifier = Modifier.padding(dimens.spaceS),
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Text(
            text = stringResource(
                if (isEditMode) {
                    R.string.admin_edit_heading
                } else {
                    R.string.admin_create_heading
                }
            ),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(
                if (isEditMode) {
                    R.string.admin_edit_description
                } else {
                    R.string.admin_create_description
                }
            ),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
    }
}

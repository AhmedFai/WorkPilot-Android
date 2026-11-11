
package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun AdminDeactivateButton(
    isActive: Boolean,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    val actionColor = if (isActive) {
        MaterialTheme.colorScheme.error
    } else {
        Color(0xFF16A34A)
    }

    OutlinedButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = !isLoading,
        shape = androidx.compose.foundation.shape.RoundedCornerShape(dimens.radiusS),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = actionColor
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(dimens.spaceXS)
        ) {
            Icon(
                imageVector = Icons.Default.PowerSettingsNew,
                contentDescription = null
            )

            Text(
                text = stringResource(
                    when {
                        isLoading -> R.string.admin_status_updating
                        isActive -> R.string.admin_deactivate
                        else -> R.string.admin_activate
                    }
                )
            )
        }
    }
}

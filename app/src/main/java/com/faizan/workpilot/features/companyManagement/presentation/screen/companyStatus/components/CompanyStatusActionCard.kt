package com.faizan.workpilot.features.companyManagement.presentation.screen.companyStatus.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun CompanyStatusActionCard(
    isActive: Boolean,
    enabled: Boolean,
    onClick: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    val actionColor = if (isActive) {
        Color(0xFFDC2626)
    } else {
        Color(0xFF16A34A)
    }

    val containerColor = if (isActive) {
        Color(0xFFFDE7E7)
    } else {
        Color(0xFFE1F5E9)
    }

    val iconBackgroundColor = if (isActive) {
        Color(0xFFFFDADA)
    } else {
        Color(0xFFCFF3DB)
    }

    val actionText = if (isActive) {
        stringResource(R.string.company_status_deactivate)
    } else {
        stringResource(R.string.company_status_activate)
    }

    val description = if (isActive) {
        stringResource(
            R.string.company_status_deactivate_description
        )
    } else {
        stringResource(
            R.string.company_status_activate_description
        )
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                enabled = enabled,
                onClick = onClick
            ),
        shape = RoundedCornerShape(dimens.radiusM),
        color = containerColor
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
                color = iconBackgroundColor
            ) {
                Icon(
                    imageVector = if (isActive) {
                        Icons.Default.Delete
                    } else {
                        Icons.Default.PowerSettingsNew
                    },
                    contentDescription = null,
                    tint = actionColor,
                    modifier = Modifier.padding(9.dp)
                )
            }

            Spacer(
                modifier = Modifier.width(dimens.spaceM)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = actionText,
                    style = MaterialTheme.typography.titleSmall,
                    color = actionColor
                )
                Spacer(modifier = Modifier.padding(top = dimens.spaceXS))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
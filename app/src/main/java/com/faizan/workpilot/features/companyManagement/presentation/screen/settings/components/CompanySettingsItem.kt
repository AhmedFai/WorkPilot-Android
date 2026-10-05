package com.faizan.workpilot.features.companyManagement.presentation.screen.settings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.faizan.workpilot.core.ui.theme.dimens

enum class CompanySettingsIcon {
    COMPANY,
    STATUS,
    ADMINS,
    DELETE
}

@Composable
fun CompanySettingsItem(
    iconType: CompanySettingsIcon,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(
                horizontal = dimens.spaceS,
                vertical = dimens.spaceS
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SettingsIconContainer(
            iconType = iconType
        )

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
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium
            )

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
            modifier = Modifier.size(dimens.iconS)
        )
    }
}

@Composable
fun SettingsIconContainer(
    iconType: CompanySettingsIcon
) {
    val dimens = MaterialTheme.dimens

    val icon = when (iconType) {
        CompanySettingsIcon.COMPANY ->
            Icons.Default.Business

        CompanySettingsIcon.STATUS ->
            Icons.Default.Security

        CompanySettingsIcon.ADMINS ->
            Icons.Default.Groups

        CompanySettingsIcon.DELETE ->
            Icons.Default.Delete
    }

    val backgroundColor = when (iconType) {
        CompanySettingsIcon.COMPANY ->
            Color(0xFFE8F1FF)

        CompanySettingsIcon.STATUS ->
            Color(0xFFECE9FF)

        CompanySettingsIcon.ADMINS ->
            Color(0xFFF0EDFF)

        CompanySettingsIcon.DELETE ->
            Color(0xFFFFD8DC)
    }

    val iconColor = when (iconType) {
        CompanySettingsIcon.COMPANY ->
            Color(0xFF1976D2)

        CompanySettingsIcon.STATUS ->
            Color(0xFF5146E5)

        CompanySettingsIcon.ADMINS ->
            Color(0xFF635BEB)

        CompanySettingsIcon.DELETE ->
            Color(0xFFE53935)
    }

    Surface(
        modifier = Modifier.size(dimens.iconL),
        shape = MaterialTheme.shapes.small,
        color = backgroundColor
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(dimens.iconS)
            )
        }
    }
}
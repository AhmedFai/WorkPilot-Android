package com.faizan.workpilot.features.dashboard.admin.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun ProjectIcon(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier.size(
            MaterialTheme.dimens.iconL
        )
    ) {

        Icon(
            imageVector = Icons.Default.Folder,
            contentDescription = null,
            modifier = Modifier.size(
                MaterialTheme.dimens.iconS
            ),
            tint = MaterialTheme.colorScheme.primary
        )
    }
}
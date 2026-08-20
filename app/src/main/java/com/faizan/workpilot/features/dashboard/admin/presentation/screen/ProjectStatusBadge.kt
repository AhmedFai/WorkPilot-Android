package com.faizan.workpilot.features.dashboard.admin.presentation.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun ProjectStatusBadge(
    status: String,
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(
            MaterialTheme.dimens.radiusS
        ),
        color = when (status.uppercase()) {

            "COMPLETED" ->
                MaterialTheme.colorScheme.secondaryContainer

            "OVERDUE" ->
                MaterialTheme.colorScheme.errorContainer

            else ->
                MaterialTheme.colorScheme.primaryContainer
        }
    ) {

        Text(
            text = status,
            modifier = Modifier.padding(
                horizontal = MaterialTheme.dimens.spaceS,
                vertical = MaterialTheme.dimens.spaceXS
            ),
            style = MaterialTheme.typography.labelSmall
        )
    }
}
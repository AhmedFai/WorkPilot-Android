package com.faizan.workpilot.features.companyManagement.presentation.screen.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun CompanySettingsSection(
    title: String,
    content: @Composable () -> Unit
) {
    val dimens = MaterialTheme.dimens

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        androidx.compose.material3.Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(
                bottom = dimens.spaceS
            )
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = dimens.space2XS
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            content()
        }
    }
}
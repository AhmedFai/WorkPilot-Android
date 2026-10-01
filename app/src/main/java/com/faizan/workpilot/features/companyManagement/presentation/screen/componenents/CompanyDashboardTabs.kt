package com.faizan.workpilot.features.companyManagement.presentation.screen.componenents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun CompanyDashboardTabs() {

    val dimens = MaterialTheme.dimens

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CompanyDashboardTab(
            title = stringResource(
                R.string.company_dashboard_overview
            ),
            selected = true,
            modifier = Modifier.weight(1f)
        )

        CompanyDashboardTab(
            title = stringResource(
                R.string.company_dashboard_admins
            ),
            selected = false,
            modifier = Modifier.weight(1f)
        )

        CompanyDashboardTab(
            title = stringResource(
                R.string.company_dashboard_settings
            ),
            selected = false,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun CompanyDashboardTab(
    title: String,
    selected: Boolean,
    modifier: Modifier = Modifier
) {

    val dimens = MaterialTheme.dimens

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            dimens.spaceXS
        )
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            color = if (selected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.space2XS)
                .background(
                    color = if (selected) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        Color.Transparent
                    },
                    shape = MaterialTheme.shapes.small
                )
        )
    }
}
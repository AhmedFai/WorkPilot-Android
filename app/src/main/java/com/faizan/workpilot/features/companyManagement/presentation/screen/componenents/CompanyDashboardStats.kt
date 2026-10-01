package com.faizan.workpilot.features.companyManagement.presentation.screen.componenents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun CompanyDashboardStats(
    totalUsers: Long,
    activeProjects: Long,
    totalTasks: Long
) {

    val dimens = MaterialTheme.dimens

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement =
            Arrangement.spacedBy(dimens.spaceXS)
    ) {

        CompanyDashboardStatCard(
            title = stringResource(
                R.string.company_dashboard_users
            ),
            value = totalUsers.toString(),
            icon = {
                Icon(
                    imageVector = Icons.Default.People,
                    contentDescription = null,
                    tint = Color(0xFF075CFD)
                )
            },
            containerColor = Color(0xFFE7F0FD),
            titleColor = Color(0xFF075CFD),
            modifier = Modifier.weight(1f)
        )

        CompanyDashboardStatCard(
            title = stringResource(
                R.string.company_dashboard_projects
            ),
            value = activeProjects.toString(),
            icon = {
                Icon(
                    imageVector = Icons.Default.Folder,
                    contentDescription = null,
                    tint = Color(0xFF6C5FFC)
                )
            },
            containerColor = Color(0xFFECEAFD),
            titleColor = Color(0xFF6C5FFC),
            modifier = Modifier.weight(1f)
        )

        CompanyDashboardStatCard(
            title = stringResource(
                R.string.company_dashboard_tasks
            ),
            value = totalTasks.toString(),
            icon = {
                Icon(
                    imageVector = Icons.Default.TaskAlt,
                    contentDescription = null,
                    tint = Color(0xFF18B463)
                )
            },
            containerColor = Color(0xFFE8F8EF),
            titleColor = Color(0xFF2E765A),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun CompanyDashboardStatCard(
    title: String,
    value: String,
    icon: @Composable () -> Unit,
    containerColor: Color,
    titleColor: Color,
    modifier: Modifier = Modifier
) {
    val dimens = MaterialTheme.dimens
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
        shape = MaterialTheme.shapes.medium
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.spaceS),
            horizontalAlignment =
                Alignment.CenterHorizontally,
            verticalArrangement =
                Arrangement.spacedBy(
                    dimens.spaceXS
                )
        ) {

            icon()

            Text(
                text = title,
                style =
                    MaterialTheme.typography.labelSmall,
                color = titleColor
            )

            Text(
                text = value,
                style =
                    MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
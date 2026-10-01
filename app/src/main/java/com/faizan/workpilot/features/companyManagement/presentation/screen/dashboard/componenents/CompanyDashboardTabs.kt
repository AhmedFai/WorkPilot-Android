package com.faizan.workpilot.features.companyManagement.presentation.screen.dashboard.componenents

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
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue

enum class CompanyManagementTab {
    OVERVIEW,
    ADMINS,
    SETTINGS
}
@Composable
fun CompanyDashboardTabs(
    selectedTab: CompanyManagementTab,
    onTabSelected: (CompanyManagementTab) -> Unit
) {
    val dimens = MaterialTheme.dimens

    val selectedIndex = when (selectedTab) {
        CompanyManagementTab.OVERVIEW -> 0
        CompanyManagementTab.ADMINS -> 1
        CompanyManagementTab.SETTINGS -> 2
    }

    val animatedIndicatorPosition by animateFloatAsState(
        targetValue = selectedIndex.toFloat(),
        animationSpec = tween(
            durationMillis = 250
        ),
        label = "company_tab_indicator"
    )

    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            CompanyDashboardTab(
                title = stringResource(
                    R.string.company_dashboard_overview
                ),
                selected = selectedTab ==
                        CompanyManagementTab.OVERVIEW,
                onClick = {
                    onTabSelected(
                        CompanyManagementTab.OVERVIEW
                    )
                },
                modifier = Modifier.weight(1f)
            )

            CompanyDashboardTab(
                title = stringResource(
                    R.string.company_dashboard_admins
                ),
                selected = selectedTab ==
                        CompanyManagementTab.ADMINS,
                onClick = {
                    onTabSelected(
                        CompanyManagementTab.ADMINS
                    )
                },
                modifier = Modifier.weight(1f)
            )

            CompanyDashboardTab(
                title = stringResource(
                    R.string.company_dashboard_settings
                ),
                selected = selectedTab ==
                        CompanyManagementTab.SETTINGS,
                onClick = {
                    onTabSelected(
                        CompanyManagementTab.SETTINGS
                    )
                },
                modifier = Modifier.weight(1f)
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth(1f / 3f)
                .height(dimens.space2XS)
                .graphicsLayer {
                    translationX =
                        (maxWidth.toPx() / 3f) *
                                animatedIndicatorPosition
                }
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.small
                )
        )
    }
}

@Composable
private fun CompanyDashboardTab(
    title: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val dimens = MaterialTheme.dimens

    Column(
        modifier = modifier
            .clickable(
                onClick = onClick
            ),
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

        Spacer(
            modifier = Modifier.height(
                dimens.space2XS
            )
        )
    }
}
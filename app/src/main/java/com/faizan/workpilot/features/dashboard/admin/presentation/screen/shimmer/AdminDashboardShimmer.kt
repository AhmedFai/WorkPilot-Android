package com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.common.ui.component.shimmer.ShimmerBox
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun AdminDashboardShimmer(
    modifier: Modifier = Modifier
) {

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal =
                MaterialTheme.dimens.screenPaddingHorizontal,
            vertical =
                MaterialTheme.dimens.spaceM
        ),
        verticalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceM
        )
    ) {

        // Header
        item {
            _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.DashboardHeaderShimmer()
        }

        // Company
        item {
            _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.CompanyCardShimmer()
        }

        // Stats
        item {
            _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.DashboardStatsShimmer()
        }

        // Quick Actions title
        item {
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(
                        0.45f
                    )
                    .padding(
                        vertical =
                            MaterialTheme.dimens.space2XS
                    )
            )
        }

        // Quick Actions
        item {
            _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.QuickActionsShimmer()
        }

        // Recent Projects title
        item {
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(
                        0.55f
                    )
                    .padding(
                        vertical =
                            MaterialTheme.dimens.space2XS
                    )
            )
        }

        // Recent Projects
        items(
            items = List(5) { it }
        ) {
            _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.RecentProjectCardShimmer()
        }
    }
}
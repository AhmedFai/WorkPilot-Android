package com.faizan.workpilot.features.dashboard.employee.presentation.screen.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.common.ui.component.shimmer.ShimmerBox
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun EmployeeDashboardShimmer(
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

            EmployeeDashboardHeaderShimmer()
        }

        // Stats
        item {

            EmployeeTaskStatsShimmer()
        }

        // Today's Tasks Header
        item {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                ShimmerBox(
                    modifier = Modifier
                        .weight(1f)
                        .height(
                            MaterialTheme.dimens.spaceL
                        )
                )

                ShimmerBox(
                    modifier = Modifier
                        .height(
                            MaterialTheme.dimens.iconM
                        )
                        .fillMaxWidth(0.10f)
                )
            }
        }

        // Today's Tasks
        items(
            items = List(5) { it }
        ) {

            EmployeeTaskCardShimmer()
        }
    }
}
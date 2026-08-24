package com.faizan.workpilot.features.dashboard.employee.presentation.screen.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.common.ui.component.shimmer.ShimmerBox
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun EmployeeTaskStatsShimmer(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceXS
        )
    ) {

        repeat(3) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        MaterialTheme.dimens.spaceS
                    ),
                verticalArrangement = Arrangement.spacedBy(
                    MaterialTheme.dimens.spaceXS
                )
            ) {

                ShimmerBox(
                    modifier = Modifier
                        .fillMaxWidth(0.70f)
                        .height(
                            MaterialTheme.dimens.spaceS
                        )
                )

                ShimmerBox(
                    modifier = Modifier
                        .fillMaxWidth(0.45f)
                        .height(
                            MaterialTheme.dimens.spaceL
                        )
                )

                ShimmerBox(
                    modifier = Modifier
                        .fillMaxWidth(0.50f)
                        .height(
                            MaterialTheme.dimens.spaceXS
                        )
                )
            }
        }
    }
}
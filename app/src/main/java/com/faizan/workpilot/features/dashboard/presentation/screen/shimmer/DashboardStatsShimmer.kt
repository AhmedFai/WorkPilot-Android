package com.faizan.workpilot.features.dashboard.presentation.screen.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun DashboardStatsShimmer() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceS
        )
    ) {

        repeat(3) {

            Card(
                modifier = Modifier.weight(1f),
                colors = CardDefaults.cardColors(
                    containerColor =
                        MaterialTheme.colorScheme.surfaceVariant
                )
            ) {

                Column(
                    modifier = Modifier.padding(
                        MaterialTheme.dimens.spaceM
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        MaterialTheme.dimens.spaceXS
                    )
                ) {

                    ShimmerBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(
                                height =
                                    MaterialTheme.dimens.spaceS,
                                width =
                                    MaterialTheme.dimens.spaceXL
                            )
                    )

                    ShimmerBox(
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .size(
                                height =
                                    MaterialTheme.dimens.spaceL,
                                width =
                                    MaterialTheme.dimens.spaceXL
                            )
                    )
                }
            }
        }
    }
}
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun QuickActionsShimmer() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceXS
        )
    ) {

        repeat(4) {

            Card(
                modifier = Modifier.weight(1f),
                colors = CardDefaults.cardColors(
                    containerColor =
                        MaterialTheme.colorScheme.surfaceVariant
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            MaterialTheme.dimens.spaceS
                        ),
                    horizontalAlignment =
                        Alignment.CenterHorizontally,
                    verticalArrangement =
                        Arrangement.spacedBy(
                            MaterialTheme.dimens.spaceXS
                        )
                ) {

                    ShimmerBox(
                        modifier = Modifier.size(
                            MaterialTheme.dimens.iconM
                        )
                    )

                    ShimmerBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(
                                height =
                                    MaterialTheme.dimens.spaceS,
                                width =
                                    MaterialTheme.dimens.spaceL
                            )
                    )
                }
            }
        }
    }
}
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
fun CompanyCardShimmer() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.primaryContainer
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    MaterialTheme.dimens.spaceM
                ),
            horizontalArrangement = Arrangement.spacedBy(
                MaterialTheme.dimens.spaceM
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            ShimmerBox(
                modifier = Modifier.size(
                    MaterialTheme.dimens.iconM
                )
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    MaterialTheme.dimens.spaceXS
                )
            ) {

                ShimmerBox(
                    modifier = Modifier
                        .fillMaxWidth(0.55f)
                        .size(
                            height =
                                MaterialTheme.dimens.spaceM,
                            width =
                                MaterialTheme.dimens.space3XL
                        )
                )

                ShimmerBox(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .size(
                            height =
                                MaterialTheme.dimens.spaceS,
                            width =
                                MaterialTheme.dimens.space4XL
                        )
                )
            }
        }
    }
}
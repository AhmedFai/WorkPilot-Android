package com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun RecentProjectCardShimmer() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surface
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

            _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.ShimmerBox(
                modifier = Modifier.size(
                    MaterialTheme.dimens.iconL
                )
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    MaterialTheme.dimens.spaceXS
                )
            ) {

                _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.ShimmerBox(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .size(
                            height =
                                MaterialTheme.dimens.spaceM,
                            width =
                                MaterialTheme.dimens.space3XL
                        )
                )

                _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.ShimmerBox(
                    modifier = Modifier
                        .fillMaxWidth(0.45f)
                        .size(
                            height =
                                MaterialTheme.dimens.spaceS,
                            width =
                                MaterialTheme.dimens.spaceXL
                        )
                )
            }

            _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.ShimmerBox(
                modifier = Modifier
                    .size(
                        width =
                            MaterialTheme.dimens.space3XL,
                        height =
                            MaterialTheme.dimens.spaceL
                    ),
                shape = RoundedCornerShape(
                    MaterialTheme.dimens.radiusS
                )
            )
        }
    }
}
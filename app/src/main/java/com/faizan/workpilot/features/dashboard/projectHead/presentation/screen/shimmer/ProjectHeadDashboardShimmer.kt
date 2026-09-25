package com.faizan.workpilot.features.dashboard.projectHead.presentation.screen.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.faizan.workpilot.core.common.ui.component.shimmer.ShimmerBox
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun ProjectHeadDashboardShimmer(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            top = MaterialTheme.dimens.spaceM,
            bottom = MaterialTheme.dimens.spaceM
        ),
        verticalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceM
        )
    ) {

        item {
            ProjectHeadHeaderShimmer()
        }

        item {
            ProjectHeadStatsShimmer()
        }

        items(3) {
            ProjectHeadProjectCardShimmer()
        }
    }
}

@Composable
private fun ProjectHeadHeaderShimmer() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = MaterialTheme.dimens.screenPaddingHorizontal
            ),
        verticalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceS
        )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    MaterialTheme.dimens.spaceS
                )
            ) {
                ShimmerBox(
                    modifier = Modifier
                        .fillMaxWidth(0.35f)
                        .height(20.dp)
                )

                ShimmerBox(
                    modifier = Modifier
                        .fillMaxWidth(0.55f)
                        .height(28.dp)
                )
            }

            Spacer(
                modifier = Modifier.width(
                    MaterialTheme.dimens.spaceM
                )
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    MaterialTheme.dimens.spaceS
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                ShimmerBox(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                )

                ShimmerBox(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                )

                ShimmerBox(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp),
                    shape = CircleShape
                )
            }
        }
    }
}

@Composable
private fun ProjectHeadStatsShimmer() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = MaterialTheme.dimens.screenPaddingHorizontal
            ),
        horizontalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceXS
        )
    ) {
        repeat(3) {
            ShimmerBox(
                modifier = Modifier
                    .weight(1f)
                    .height(90.dp)
            )
        }
    }
}

@Composable
private fun ProjectHeadProjectCardShimmer() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = MaterialTheme.dimens.screenPaddingHorizontal
            ),
        verticalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceS
        )
    ) {
        ShimmerBox(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
        )

        ShimmerBox(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
    }
}
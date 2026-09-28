package com.faizan.workpilot.features.dashboard.superAdmin.presentation.screen.shimmer


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.faizan.workpilot.core.common.ui.component.shimmer.ShimmerBox
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun SuperAdminDashboardShimmer(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            horizontal = MaterialTheme.dimens.screenPaddingHorizontal,
            vertical = MaterialTheme.dimens.spaceM
        ),
        verticalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceM
        )
    ) {

        item {
            SuperAdminHeaderShimmer()
        }

        item {
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(
                    MaterialTheme.dimens.radiusM
                )
            )
        }

        items(5) {
            SuperAdminCompanyCardShimmer()
        }
    }
}

@Composable
private fun SuperAdminHeaderShimmer() {
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
                modifier = Modifier.size(40.dp)
            )

            ShimmerBox(
                modifier = Modifier.size(40.dp)
            )

            ShimmerBox(
                modifier = Modifier.size(40.dp),
                shape = CircleShape
            )
        }
    }
}

@Composable
private fun SuperAdminCompanyCardShimmer() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
            .padding(
                horizontal = MaterialTheme.dimens.spaceM
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        ShimmerBox(
            modifier = Modifier.size(48.dp),
            shape = CircleShape
        )

        Spacer(
            modifier = Modifier.width(
                MaterialTheme.dimens.spaceM
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
                    .fillMaxWidth(0.65f)
                    .height(20.dp)
            )

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .height(14.dp)
            )
        }

        Spacer(
            modifier = Modifier.width(
                MaterialTheme.dimens.spaceS
            )
        )

        ShimmerBox(
            modifier = Modifier
                .size(16.dp)
        )
    }
}
package com.faizan.workpilot.features.dashboard.employee.presentation.screen.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.common.ui.component.shimmer.ShimmerBox
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun EmployeeDashboardHeaderShimmer(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceS
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                MaterialTheme.dimens.space2XS
            )
        ) {

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.55f)
                    .height(
                        MaterialTheme.dimens.spaceM
                    )
            )

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(
                        MaterialTheme.dimens.spaceL
                    )
            )
        }

        ShimmerBox(
            modifier = Modifier.size(
                MaterialTheme.dimens.iconS
            )
        )

        ShimmerBox(
            modifier = Modifier.size(
                MaterialTheme.dimens.iconS
            )
        )

        ShimmerBox(
            modifier = Modifier.size(
                MaterialTheme.dimens.avatarS
            ),
            shape = CircleShape
        )
    }
}
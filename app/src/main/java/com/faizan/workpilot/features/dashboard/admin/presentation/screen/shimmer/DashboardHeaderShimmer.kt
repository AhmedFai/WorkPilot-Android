package com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun DashboardHeaderShimmer() {

    Row(
        modifier = Modifier.fillMaxWidth(),
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

            _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(
                        0.55f
                    )
                    .size(
                        height =
                            MaterialTheme.dimens.spaceM,
                        width =
                            MaterialTheme.dimens.space2XL
                    )
            )

            _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(
                        0.75f
                    )
                    .size(
                        height =
                            MaterialTheme.dimens.spaceL,
                        width =
                            MaterialTheme.dimens.space3XL
                    )
            )
        }

        _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.ShimmerBox(
            modifier = Modifier.size(
                MaterialTheme.dimens.iconS
            )
        )

        _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.ShimmerBox(
            modifier = Modifier.size(
                MaterialTheme.dimens.iconS
            )
        )

        _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer.ShimmerBox(
            modifier = Modifier
                .size(
                    MaterialTheme.dimens.avatarS
                )
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            MaterialTheme.colorScheme.surfaceVariant,
                            MaterialTheme.colorScheme.onSurface.copy(
                                alpha = 0.08f
                            ),
                            MaterialTheme.colorScheme.surfaceVariant
                        )
                    ),
                    shape = CircleShape
                )
        )
    }
}
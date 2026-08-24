package com.faizan.workpilot.features.dashboard.employee.presentation.screen.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.common.ui.component.shimmer.ShimmerBox
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun EmployeeTaskCardShimmer(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                MaterialTheme.dimens.spaceM
            ),
        horizontalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceS
        ),
        verticalAlignment = Alignment.Top
    ) {

        // Status indicator
        ShimmerBox(
            modifier = Modifier.size(
                MaterialTheme.dimens.iconS
            ),
            shape = RoundedCornerShape(
                MaterialTheme.dimens.radiusS
            )
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                MaterialTheme.dimens.spaceXS
            )
        ) {

            // Task title
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.72f)
                    .size(
                        height =
                            MaterialTheme.dimens.spaceM,
                        width =
                            MaterialTheme.dimens.spaceXL
                    )
            )

            // Project
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.45f)
                    .size(
                        height =
                            MaterialTheme.dimens.spaceS,
                        width =
                            MaterialTheme.dimens.spaceL
                    )
            )

            // Priority + deadline
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    MaterialTheme.dimens.spaceS
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                ShimmerBox(
                    modifier = Modifier.size(
                        width =
                            MaterialTheme.dimens.spaceL,
                        height =
                            MaterialTheme.dimens.spaceS
                    )
                )

                ShimmerBox(
                    modifier = Modifier.size(
                        MaterialTheme.dimens.iconXS
                    )
                )

                ShimmerBox(
                    modifier = Modifier.size(
                        width =
                            MaterialTheme.dimens.spaceXL,
                        height =
                            MaterialTheme.dimens.spaceS
                    )
                )
            }
        }
    }
}
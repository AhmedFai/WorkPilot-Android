package com.faizan.workpilot.features.companyManagement.presentation.screen.dashboard.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.common.ui.component.shimmer.ShimmerBox
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun CompanyDashboardShimmer() {

    val dimens = MaterialTheme.dimens

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(
                start = dimens.screenPaddingHorizontal,
                top = dimens.screenPaddingVertical,
                end = dimens.screenPaddingHorizontal
            ),
        contentPadding = PaddingValues(
            bottom = dimens.spaceS
        ),
        verticalArrangement =
            Arrangement.spacedBy(dimens.spaceM)
    ) {

        // Header
        item {
            CompanyDashboardHeaderShimmer()
        }

        // Overview statistics
        item {
            CompanyDashboardStatsShimmer()
        }

        // Task status
        item {
            CompanyDashboardTaskStatusShimmer()
        }

        // Recent activity
        item {
            CompanyDashboardRecentActivityShimmer()
        }

        // Admin preview
        item {
            CompanyDashboardAdminPreviewShimmer()
        }
    }
}

@Composable
private fun CompanyDashboardHeaderShimmer() {

    val dimens = MaterialTheme.dimens

    Column(
        verticalArrangement =
            Arrangement.spacedBy(dimens.spaceXS)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            // Back button
            ShimmerBox(
                modifier = Modifier.size(
                    dimens.minTouchTarget
                ),
                shape = MaterialTheme.shapes.small
            )

            // Company name + overview
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        horizontal = dimens.spaceXS
                    ),
                verticalArrangement =
                    Arrangement.spacedBy(
                        dimens.space2XS
                    )
            ) {

                ShimmerBox(
                    modifier = Modifier
                        .fillMaxWidth(0.70f)
                        .size(
                            height = dimens.iconM,
                            width = dimens.iconM
                        )
                )

                ShimmerBox(
                    modifier = Modifier
                        .fillMaxWidth(0.40f)
                        .size(
                            height = dimens.iconXS,
                            width = dimens.iconXS
                        )
                )
            }

            // Active chip
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.16f)
                    .size(
                        height = dimens.iconS,
                        width = dimens.iconS
                    ),
                shape = MaterialTheme.shapes.small
            )

            // Menu
            ShimmerBox(
                modifier = Modifier.size(
                    dimens.minTouchTarget
                ),
                shape = MaterialTheme.shapes.small
            )
        }

        // Tabs
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =
                Arrangement.SpaceEvenly
        ) {

            repeat(3) {

                ShimmerBox(
                    modifier = Modifier
                        .fillMaxWidth(0.20f)
                        .size(
                            height = dimens.iconXS,
                            width = dimens.iconXS
                        )
                )
            }
        }
    }
}

@Composable
private fun CompanyDashboardStatsShimmer() {

    val dimens = MaterialTheme.dimens

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement =
            Arrangement.spacedBy(dimens.spaceXS)
    ) {

        repeat(3) {

            CompanyDashboardStatShimmer(
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun CompanyDashboardStatShimmer(
    modifier: Modifier = Modifier
) {

    val dimens = MaterialTheme.dimens

    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.spaceS),
            horizontalAlignment =
                Alignment.CenterHorizontally,
            verticalArrangement =
                Arrangement.spacedBy(
                    dimens.spaceXS
                )
        ) {

            ShimmerBox(
                modifier = Modifier.size(
                    dimens.iconS
                ),
                shape = MaterialTheme.shapes.small
            )

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.65f)
                    .size(
                        height = dimens.iconXS,
                        width = dimens.iconXS
                    )
            )

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.45f)
                    .size(
                        height = dimens.iconM,
                        width = dimens.iconM
                    )
            )
        }
    }
}

@Composable
private fun CompanyDashboardTaskStatusShimmer() {

    val dimens = MaterialTheme.dimens

    Column(
        verticalArrangement =
            Arrangement.spacedBy(dimens.spaceS)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =
                Arrangement.SpaceBetween
        ) {

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.35f)
                    .size(
                        height = dimens.iconS,
                        width = dimens.iconS
                    )
            )

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .size(
                        height = dimens.iconXS,
                        width = dimens.iconXS
                    )
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =
                Arrangement.spacedBy(dimens.spaceXS)
        ) {

            repeat(4) {

                CompanyDashboardTaskStatusCardShimmer(
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun CompanyDashboardTaskStatusCardShimmer(
    modifier: Modifier = Modifier
) {

    val dimens = MaterialTheme.dimens

    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.spaceS),
            horizontalAlignment =
                Alignment.CenterHorizontally,
            verticalArrangement =
                Arrangement.spacedBy(
                    dimens.spaceXS
                )
        ) {

            ShimmerBox(
                modifier = Modifier.size(
                    dimens.iconS
                ),
                shape = MaterialTheme.shapes.small
            )

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.70f)
                    .size(
                        height = dimens.iconXS,
                        width = dimens.iconXS
                    )
            )

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.50f)
                    .size(
                        height = dimens.iconM,
                        width = dimens.iconM
                    )
            )
        }
    }
}

@Composable
private fun CompanyDashboardRecentActivityShimmer() {

    val dimens = MaterialTheme.dimens

    Column(
        verticalArrangement =
            Arrangement.spacedBy(dimens.spaceS)
    ) {

        // Section title + View All
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment =
                Alignment.CenterVertically,
            horizontalArrangement =
                Arrangement.SpaceBetween
        ) {

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.40f)
                    .size(
                        height = dimens.iconS,
                        width = dimens.iconS
                    )
            )

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.18f)
                    .size(
                        height = dimens.iconXS,
                        width = dimens.iconXS
                    )
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        ) {

            Column {

                repeat(4) { index ->

                    CompanyDashboardActivityRowShimmer()

                    if (index < 3) {

                        HorizontalDivider(
                            modifier = Modifier.padding(
                                horizontal = dimens.spaceM
                            ),
                            color =
                                MaterialTheme.colorScheme.outlineVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CompanyDashboardActivityRowShimmer() {

    val dimens = MaterialTheme.dimens

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimens.spaceM,
                vertical = dimens.spaceS
            ),
        verticalAlignment =
            Alignment.CenterVertically,
        horizontalArrangement =
            Arrangement.spacedBy(dimens.spaceS)
    ) {

        // Activity icon
        Surface(
            shape = MaterialTheme.shapes.small,
            color = MaterialTheme.colorScheme.surfaceVariant
        ) {
            ShimmerBox(
                modifier = Modifier
                    .padding(dimens.spaceS)
                    .size(dimens.iconM),
                shape = MaterialTheme.shapes.small
            )
        }

        // Activity content
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement =
                Arrangement.spacedBy(
                    dimens.space2XS
                )
        ) {

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.72f)
                    .size(
                        height = dimens.iconXS,
                        width = dimens.iconXS
                    )
            )

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.42f)
                    .size(
                        height = dimens.iconXS,
                        width = dimens.iconXS
                    )
            )

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.88f)
                    .size(
                        height = dimens.iconXS,
                        width = dimens.iconXS
                    )
            )
        }

        // Relative time
        ShimmerBox(
            modifier = Modifier
                .fillMaxWidth(0.12f)
                .size(
                    height = dimens.iconXS,
                    width = dimens.iconXS
                )
        )
    }
}

@Composable
private fun CompanyDashboardAdminPreviewShimmer() {

    val dimens = MaterialTheme.dimens

    Column(
        verticalArrangement =
            Arrangement.spacedBy(dimens.spaceS)
    ) {

        // Section title + View All
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment =
                Alignment.CenterVertically,
            horizontalArrangement =
                Arrangement.SpaceBetween
        ) {

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .size(
                        height = dimens.iconS,
                        width = dimens.iconS
                    )
            )

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.18f)
                    .size(
                        height = dimens.iconXS,
                        width = dimens.iconXS
                    )
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        ) {

            Column {

                repeat(2) { index ->

                    CompanyDashboardAdminRowShimmer()

                    if (index < 1) {

                        HorizontalDivider(
                            modifier = Modifier.padding(
                                horizontal = dimens.spaceM
                            ),
                            color =
                                MaterialTheme.colorScheme.outlineVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CompanyDashboardAdminRowShimmer() {

    val dimens = MaterialTheme.dimens

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimens.spaceM,
                vertical = dimens.spaceS
            ),
        verticalAlignment =
            Alignment.CenterVertically,
        horizontalArrangement =
            Arrangement.spacedBy(dimens.spaceS)
    ) {

        // Avatar
        Surface(
            shape = MaterialTheme.shapes.small,
            color = MaterialTheme.colorScheme.surfaceVariant
        ) {
            ShimmerBox(
                modifier = Modifier
                    .padding(dimens.spaceS)
                    .size(dimens.iconM),
                shape = MaterialTheme.shapes.small
            )
        }

        // Name + email
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement =
                Arrangement.spacedBy(
                    dimens.space2XS
                )
        ) {

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.55f)
                    .size(
                        height = dimens.iconXS,
                        width = dimens.iconXS
                    )
            )

            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.70f)
                    .size(
                        height = dimens.iconXS,
                        width = dimens.iconXS
                    )
            )
        }

        // Active chip
        ShimmerBox(
            modifier = Modifier
                .fillMaxWidth(0.18f)
                .size(
                    height = dimens.iconXS,
                    width = dimens.iconXS
                ),
            shape = MaterialTheme.shapes.small
        )
    }
}
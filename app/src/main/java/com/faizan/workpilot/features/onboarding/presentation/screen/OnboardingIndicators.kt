package com.faizan.workpilot.features.onboarding.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun OnboardingIndicators(
    pageCount: Int,
    currentPage: Int,
    onPageSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val dimens = MaterialTheme.dimens

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            dimens.spaceXS
        )
    ) {
        repeat(pageCount) { index ->

            val isSelected = index == currentPage

            Box(
                modifier = Modifier
                    .size(
                        if (isSelected) {
                            dimens.indicatorSelectedSize
                        } else {
                            dimens.indicatorSize
                        }
                    )
                    .background(
                        color = if (isSelected) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                                .copy(alpha = 0.25f)
                        },
                        shape = CircleShape
                    )
                    .clickable {
                        onPageSelected(index)
                    }
            )
        }
    }
}
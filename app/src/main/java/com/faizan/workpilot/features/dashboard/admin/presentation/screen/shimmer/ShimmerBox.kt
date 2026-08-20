package com.faizan.workpilot.features.dashboard.admin.presentation.screen.shimmer

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import androidx.compose.material3.MaterialTheme
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun ShimmerBox(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(
        MaterialTheme.dimens.radiusS
    )
): Unit {

    val transition =
        rememberInfiniteTransition(
            label = "shimmer"
        )

    val translateX by transition.animateFloat(
        initialValue = -500f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1200,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmer_translation"
    )

    val baseColor =
        MaterialTheme.colorScheme.surfaceVariant

    val highlightColor =
        MaterialTheme.colorScheme.onSurface.copy(
            alpha = 0.08f
        )

    val brush = Brush.linearGradient(
        colors = listOf(
            baseColor,
            highlightColor,
            baseColor
        ),
        start = Offset(
            x = translateX,
            y = 0f
        ),
        end = Offset(
            x = translateX + 300f,
            y = 0f
        )
    )

    androidx.compose.foundation.layout.Box(
        modifier = modifier.background(
            brush = brush,
            shape = shape
        )
    )
}
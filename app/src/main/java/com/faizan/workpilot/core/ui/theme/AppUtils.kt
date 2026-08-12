package com.faizan.workpilot.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember

@Composable
fun AppUtils(
    appDimens: Dimens,
    content: @Composable () -> Unit
) {
    val dimens = remember(appDimens) {
        appDimens
    }

    CompositionLocalProvider(
        LocalAppDimens provides dimens
    ) {
        content()
    }
}

val LocalAppDimens = compositionLocalOf {
    CompactDimens
}

val MaterialTheme.dimens: Dimens
    @Composable
    get() = LocalAppDimens.current
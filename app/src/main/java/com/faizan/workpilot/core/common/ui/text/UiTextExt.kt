package com.faizan.workpilot.core.common.ui.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun UiText.asString(): String {
    return when (this) {

        is UiText.Dynamic -> value

        is UiText.StringRes -> {
            stringResource(
                id = resId,
                *args.toTypedArray()
            )
        }
    }
}
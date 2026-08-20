package com.faizan.workpilot.core.network.error

import com.faizan.workpilot.core.common.ui.text.UiText

data class NetworkError(
    val type: NetworkErrorType,
    val message: UiText
)

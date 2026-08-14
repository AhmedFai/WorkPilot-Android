package com.faizan.workpilot.features.login.presentation.model

import com.faizan.workpilot.core.common.ui.text.UiText

sealed interface LoginUiEvent {

    data class ShowSuccess(
        val message: UiText
    ) : LoginUiEvent

    data class ShowError(
        val message: UiText
    ) : LoginUiEvent

    data object LoginSuccess : LoginUiEvent
}

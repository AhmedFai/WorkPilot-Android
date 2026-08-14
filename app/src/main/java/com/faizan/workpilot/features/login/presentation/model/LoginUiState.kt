package com.faizan.workpilot.features.login.presentation.model

import com.faizan.workpilot.core.common.ui.text.UiText

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val emailError: UiText? = null,
    val passwordError: UiText? = null,
    val generalError: UiText? = null
)

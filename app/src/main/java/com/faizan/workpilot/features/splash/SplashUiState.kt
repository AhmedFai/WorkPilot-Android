package com.faizan.workpilot.features.splash

data class SplashUiState(
    val isOnboardingCompleted: Boolean = false,
    val isLoggedIn: Boolean = false,
    val role: String? = null,
    val isReady: Boolean = false
)

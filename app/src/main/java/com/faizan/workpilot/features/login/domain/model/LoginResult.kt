package com.faizan.workpilot.features.login.domain.model

data class LoginResult(
    val message: String,
    val accessToken: String,
    val refreshToken: String,
    val user: UserSession
)
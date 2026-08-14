package com.faizan.workpilot.features.login.data.model

data class LoginResponseDto(
    val accessToken: String,
    val refreshToken: String,
    val user: LoggedInUserDto
)

package com.faizan.workpilot.features.login.data.model

data class LoggedInUserDto(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val role: String
)

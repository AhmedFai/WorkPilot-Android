package com.faizan.workpilot.features.login.domain.model

data class UserSession(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val role: String
)

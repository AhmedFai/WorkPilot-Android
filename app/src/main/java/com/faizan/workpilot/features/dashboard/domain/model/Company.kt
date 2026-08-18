package com.faizan.workpilot.features.dashboard.domain.model

data class Company(
    val id: Long,
    val name: String,
    val email: String,
    val logoUrl: String?
)

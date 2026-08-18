package com.faizan.workpilot.features.dashboard.domain.model

data class RecentProject(
    val id: Long,
    val name: String,
    val status: String,
    val logoUrl: String?
)

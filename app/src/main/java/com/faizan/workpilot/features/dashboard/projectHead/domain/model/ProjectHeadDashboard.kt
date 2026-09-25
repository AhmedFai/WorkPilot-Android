package com.faizan.workpilot.features.dashboard.projectHead.domain.model

data class ProjectHeadDashboard(
    val currentProjectCount: Long,
    val taskCount: Long,
    val overdueTaskCount: Long,
    val projects: List<ProjectHeadProject>
)

package com.faizan.workpilot.features.dashboard.projectHead.data.model

data class ProjectHeadDashboardDto(
    val currentProjectCount: Long,
    val taskCount: Long,
    val overdueTaskCount: Long,
    val projects: List<ProjectHeadProjectDto>
)

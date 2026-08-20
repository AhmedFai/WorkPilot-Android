package com.faizan.workpilot.features.dashboard.admin.data.model

data class AdminDashboardDto(
    val company: CompanyDto,
    val employeeCount: Int,
    val projectCount: Int,
    val taskCount: Int,
    val recentProjects: List<RecentProjectDto>
)

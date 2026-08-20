package com.faizan.workpilot.features.dashboard.admin.domain.model

data class AdminDashboard(
    val company: Company,
    val employeeCount: Int,
    val projectCount: Int,
    val taskCount: Int,
    val recentProjects: List<RecentProject>
)

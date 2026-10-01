package com.faizan.workpilot.features.companyManagement.domain.model

data class CompanyDashboard(
    val company: CompanyOverviewCompany,
    val totalUsers: Long,
    val activeProjects: Long,
    val totalTasks: Long,
    val taskSummary: CompanyTaskSummary,
    val recentActivities: List<CompanyActivityPreview>,
    val adminPreview: List<CompanyAdminPreview>
)
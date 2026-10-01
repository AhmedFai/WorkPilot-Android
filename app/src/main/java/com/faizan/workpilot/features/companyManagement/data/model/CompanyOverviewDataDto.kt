package com.faizan.workpilot.features.companyManagement.data.model

data class CompanyOverviewDataDto(
    val company: CompanyOverviewCompanyDto,
    val totalUsers: Long,
    val activeProjects: Long,
    val totalTasks: Long,
    val taskSummary: CompanyTaskSummaryDto,
    val recentActivities: List<CompanyActivityPreviewDto>,
    val adminPreview: List<CompanyAdminPreviewDto>
)
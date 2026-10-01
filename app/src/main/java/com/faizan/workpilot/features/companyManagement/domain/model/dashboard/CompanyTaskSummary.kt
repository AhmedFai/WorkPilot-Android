package com.faizan.workpilot.features.companyManagement.domain.model.dashboard

data class CompanyTaskSummary(
    val pending: Long,
    val inProgress: Long,
    val completed: Long,
    val overdue: Long
)
package com.faizan.workpilot.features.companyManagement.data.model

data class CompanyTaskSummaryDto(
    val pending: Long,
    val inProgress: Long,
    val completed: Long,
    val overdue: Long
)
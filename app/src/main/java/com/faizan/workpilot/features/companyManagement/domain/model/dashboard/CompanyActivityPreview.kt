package com.faizan.workpilot.features.companyManagement.domain.model.dashboard

data class CompanyActivityPreview(
    val id: Long,
    val type: String,
    val message: String,
    val description: String?,
    val performedBy: String,
    val createdAt: String
)
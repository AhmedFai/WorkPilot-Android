package com.faizan.workpilot.features.companyManagement.data.model

data class CompanyActivityPreviewDto(
    val id: Long,
    val type: String,
    val message: String,
    val description: String?,
    val performedBy: String,
    val createdAt: String
)
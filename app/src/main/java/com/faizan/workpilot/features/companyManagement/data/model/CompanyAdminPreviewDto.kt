package com.faizan.workpilot.features.companyManagement.data.model

data class CompanyAdminPreviewDto(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val active: Boolean
)
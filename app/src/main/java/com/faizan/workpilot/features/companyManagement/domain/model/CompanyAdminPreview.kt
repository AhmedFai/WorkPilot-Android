package com.faizan.workpilot.features.companyManagement.domain.model

data class CompanyAdminPreview(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val active: Boolean
)
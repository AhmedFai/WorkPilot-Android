package com.faizan.workpilot.features.companyManagement.domain.model.admin

data class CompanyAdminDetails(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val role: String,
    val companyId: Long,
    val companyName: String,
    val phoneNumber: String,
    val designation: String?,
    val active: Boolean,
    val createdAt: String,
    val updatedAt: String
)

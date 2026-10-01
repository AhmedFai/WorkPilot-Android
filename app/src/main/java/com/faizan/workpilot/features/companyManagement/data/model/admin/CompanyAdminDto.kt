package com.faizan.workpilot.features.companyManagement.data.model.admin

data class CompanyAdminDto(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val active: Boolean,
    val createdAt: String,
    val updatedAt: String
)
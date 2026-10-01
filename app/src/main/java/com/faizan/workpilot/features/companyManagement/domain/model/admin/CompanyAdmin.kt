package com.faizan.workpilot.features.companyManagement.domain.model.admin

data class CompanyAdmin(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val active: Boolean,
    val createdAt: String,
    val updatedAt: String
)
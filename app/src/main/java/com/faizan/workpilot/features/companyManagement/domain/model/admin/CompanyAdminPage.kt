package com.faizan.workpilot.features.companyManagement.domain.model.admin

data class CompanyAdminPage(
    val admins: List<CompanyAdmin>,
    val page: Int,
    val size: Int,
    val totalElements: Long,
    val totalPages: Int
)

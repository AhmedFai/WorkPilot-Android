package com.faizan.workpilot.features.companyManagement.data.model.admin

data class CompanyAdminsDataDto(
    val content: List<CompanyAdminDto>,
    val page: Int,
    val size: Int,
    val totalElements: Long,
    val totalPages: Int
)
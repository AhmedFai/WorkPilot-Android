package com.faizan.workpilot.features.companyManagement.data.model.admin

data class CreateCompanyAdminRequestDto(
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val password: String
)
package com.faizan.workpilot.features.companyManagement.domain.model.editCompanyInfo

data class UpdateCompanyInfo(
    val name: String,
    val email: String,
    val phone: String?,
    val website: String?,
    val addressLine1: String?,
    val addressLine2: String?,
    val city: String?,
    val state: String?,
    val postalCode: String?,
    val country: String?
)

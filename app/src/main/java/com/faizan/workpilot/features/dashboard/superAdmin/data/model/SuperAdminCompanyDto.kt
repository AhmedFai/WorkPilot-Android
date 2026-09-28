package com.faizan.workpilot.features.dashboard.superAdmin.data.model

data class SuperAdminCompanyDto(
    val id: Long,
    val name: String,
    val logoUrl: String?,
    val active: Boolean
)

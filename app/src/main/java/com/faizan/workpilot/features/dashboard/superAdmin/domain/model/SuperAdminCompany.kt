package com.faizan.workpilot.features.dashboard.superAdmin.domain.model

data class SuperAdminCompany(
    val id: Long,
    val name: String,
    val logoUrl: String?,
    val active: Boolean
)

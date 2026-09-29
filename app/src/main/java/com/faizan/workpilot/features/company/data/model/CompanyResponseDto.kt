package com.faizan.workpilot.features.company.data.model

data class CompanyResponseDto(
    val id: Long,
    val name: String,
    val email: String,
    val phone: String?,
    val website: String?,
    val addressLine1: String?,
    val addressLine2: String?,
    val city: String?,
    val state: String?,
    val postalCode: String?,
    val country: String?,
    val createdAt: String,
    val updatedAt: String,
    val active: Boolean
)

package com.faizan.workpilot.features.dashboard.superAdmin.data.mapper

import com.faizan.workpilot.features.dashboard.superAdmin.data.model.SuperAdminCompanyDto
import com.faizan.workpilot.features.dashboard.superAdmin.data.model.SuperAdminDashboardDto
import com.faizan.workpilot.features.dashboard.superAdmin.domain.model.SuperAdminCompany
import com.faizan.workpilot.features.dashboard.superAdmin.domain.model.SuperAdminDashboard

fun SuperAdminDashboardDto.toDomain(): SuperAdminDashboard {
    return SuperAdminDashboard(
        companies = data.companies.map {
            it.toDomain()
        }
    )
}

fun SuperAdminCompanyDto.toDomain(): SuperAdminCompany {
    return SuperAdminCompany(
        id = id,
        name = name,
        logoUrl = logoUrl,
        active = active
    )
}
package com.faizan.workpilot.features.companyManagement.data.mapper

import com.faizan.workpilot.features.companyManagement.data.model.admin.CompanyAdminDto
import com.faizan.workpilot.features.companyManagement.data.model.admin.CompanyAdminsDataDto
import com.faizan.workpilot.features.companyManagement.data.model.admin.CompanyAdminsResponseDto
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdmin
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminPage

fun CompanyAdminsResponseDto.toDomain(): CompanyAdminPage {
    return data.toDomain()
}

private fun CompanyAdminsDataDto.toDomain(): CompanyAdminPage {
    return CompanyAdminPage(
        admins = content.map { it.toDomain() },
        page = page,
        size = size,
        totalElements = totalElements,
        totalPages = totalPages
    )
}

private fun CompanyAdminDto.toDomain(): CompanyAdmin {
    return CompanyAdmin(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        active = active,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
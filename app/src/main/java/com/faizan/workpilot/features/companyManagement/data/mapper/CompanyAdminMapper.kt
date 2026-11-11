package com.faizan.workpilot.features.companyManagement.data.mapper

import com.faizan.workpilot.features.companyManagement.data.model.admin.CompanyAdminDto
import com.faizan.workpilot.features.companyManagement.data.model.admin.CompanyAdminsDataDto
import com.faizan.workpilot.features.companyManagement.data.model.admin.CompanyAdminsResponseDto
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdmin
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminPage
import com.faizan.workpilot.features.companyManagement.data.model.admin.CompanyAdminDetailsDto
import com.faizan.workpilot.features.companyManagement.data.model.admin.CompanyAdminDetailsResponseDto
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminDetails
import com.faizan.workpilot.features.companyManagement.data.model.admin.CreateCompanyAdminResponseDto

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

fun CompanyAdminDetailsResponseDto.toDomain(): CompanyAdminDetails =
    data.toDomain()

 fun CompanyAdminDetailsDto.toDomain(): CompanyAdminDetails =
    CompanyAdminDetails(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        role = role,
        companyId = companyId,
        companyName = companyName,
        phoneNumber = phoneNumber,
        designation = designation,
        active = active,
        createdAt = createdAt,
        updatedAt = updatedAt
    )

fun CreateCompanyAdminResponseDto.toDomain(): CompanyAdmin =
    data.toDomain()
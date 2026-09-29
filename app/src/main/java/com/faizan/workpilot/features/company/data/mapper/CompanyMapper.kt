package com.faizan.workpilot.features.company.data.mapper

import com.faizan.workpilot.features.company.data.model.CompanyResponseDto
import com.faizan.workpilot.features.company.domain.model.Company

fun CompanyResponseDto.toDomain(): Company {
    return Company(
        id = id,
        name = name,
        email = email,
        phone = phone,
        website = website,
        addressLine1 = addressLine1,
        addressLine2 = addressLine2,
        city = city,
        state = state,
        postalCode = postalCode,
        country = country,
        createdAt = createdAt,
        updatedAt = updatedAt,
        active = active
    )
}
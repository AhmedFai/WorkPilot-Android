package com.faizan.workpilot.features.companyManagement.data.mapper

import android.R.attr.data
import com.faizan.workpilot.features.companyManagement.data.model.companyInfo.CompanyInfoDataDto
import com.faizan.workpilot.features.companyManagement.data.model.companyInfo.CompanyInfoResponseDto
import com.faizan.workpilot.features.companyManagement.data.model.companyStatus.UpdateCompanyStatusRequest
import com.faizan.workpilot.features.companyManagement.data.model.editCompanyInfo.UpdateCompanyRequest
import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo
import com.faizan.workpilot.features.companyManagement.domain.model.companyStatus.UpdateCompanyStatus
import com.faizan.workpilot.features.companyManagement.domain.model.editCompanyInfo.UpdateCompanyInfo

fun CompanyInfoResponseDto.toDomain(): CompanyInfo {
    return data.toDomain()
}

private fun CompanyInfoDataDto.toDomain(): CompanyInfo {
    return CompanyInfo(
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

fun UpdateCompanyInfo.toRequest(): UpdateCompanyRequest {
    return UpdateCompanyRequest(
        name = name,
        email = email,
        phone = phone,
        website = website,
        addressLine1 = addressLine1,
        addressLine2 = addressLine2,
        city = city,
        state = state,
        postalCode = postalCode,
        country = country
    )
}

fun UpdateCompanyStatus.toRequest(): UpdateCompanyStatusRequest {
    return UpdateCompanyStatusRequest(
        active = active
    )
}
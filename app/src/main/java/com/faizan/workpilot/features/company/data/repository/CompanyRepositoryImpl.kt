package com.faizan.workpilot.features.company.data.repository

import com.faizan.workpilot.features.company.data.api.CompanyApi
import com.faizan.workpilot.features.company.data.mapper.toDomain
import com.faizan.workpilot.features.company.data.model.CreateCompanyRequestDto
import com.faizan.workpilot.features.company.domain.model.Company
import com.faizan.workpilot.features.company.domain.model.CreateCompanyResult
import com.faizan.workpilot.features.company.domain.repository.CompanyRepository
import javax.inject.Inject

class CompanyRepositoryImpl @Inject constructor(
    private val api: CompanyApi
) : CompanyRepository {

    override suspend fun createCompany(
        name: String,
        email: String,
        phone: String?,
        website: String?,
        addressLine1: String?,
        addressLine2: String?,
        city: String?,
        state: String?,
        postalCode: String?,
        country: String?
    ): CreateCompanyResult {
        val response = api.createCompany(
            CreateCompanyRequestDto(
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
        )

        return CreateCompanyResult(
            message = response.message,
            company = response.data.toDomain()
        )
    }
}
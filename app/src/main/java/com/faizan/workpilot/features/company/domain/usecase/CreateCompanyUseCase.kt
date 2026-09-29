package com.faizan.workpilot.features.company.domain.usecase

import com.faizan.workpilot.features.company.domain.model.CreateCompanyResult
import com.faizan.workpilot.features.company.domain.repository.CompanyRepository
import javax.inject.Inject

class CreateCompanyUseCase @Inject constructor(
    private val repository: CompanyRepository
) {
    suspend operator fun invoke(
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

        return repository.createCompany(
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
}
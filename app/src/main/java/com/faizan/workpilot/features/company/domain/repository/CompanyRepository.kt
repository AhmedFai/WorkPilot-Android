package com.faizan.workpilot.features.company.domain.repository

import com.faizan.workpilot.features.company.domain.model.Company
import com.faizan.workpilot.features.company.domain.model.CreateCompanyResult

interface CompanyRepository {

    suspend fun createCompany(
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
    ): CreateCompanyResult
}
package com.faizan.workpilot.features.companyManagement.domain.usecase.admin

import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdmin
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyAdminRepository
import javax.inject.Inject

class CreateCompanyAdminUseCase @Inject constructor(
    private val repository: CompanyAdminRepository
) {

    suspend operator fun invoke(
        companyId: Long,
        firstName: String,
        lastName: String,
        email: String,
        phoneNumber: String,
        password: String
    ): CompanyAdmin {

        return repository.createCompanyAdmin(
            companyId = companyId,
            firstName = firstName,
            lastName = lastName,
            email = email,
            phoneNumber = phoneNumber,
            password = password
        )
    }
}
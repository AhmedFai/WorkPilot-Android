
package com.faizan.workpilot.features.companyManagement.domain.usecase.admin

import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminUpdateResult
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyAdminRepository
import javax.inject.Inject

class UpdateCompanyAdminUseCase @Inject constructor(
    private val repository: CompanyAdminRepository
) {

    suspend operator fun invoke(
        companyId: Long,
        adminId: Long,
        firstName: String,
        lastName: String,
        phoneNumber: String
    ): CompanyAdminUpdateResult {

        return repository.updateCompanyAdmin(
            companyId = companyId,
            adminId = adminId,
            firstName = firstName,
            lastName = lastName,
            phoneNumber = phoneNumber
        )
    }
}

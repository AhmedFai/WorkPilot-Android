package com.faizan.workpilot.features.companyManagement.domain.usecase.admin

import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminDetails
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyAdminRepository
import javax.inject.Inject

class UpdateCompanyAdminStatusUseCase @Inject constructor(
    private val repository: CompanyAdminRepository
) {

    suspend operator fun invoke(
        companyId: Long,
        adminId: Long,
        active: Boolean
    ): CompanyAdminDetails {

        return repository.updateCompanyAdminStatus(
            companyId = companyId,
            adminId = adminId,
            active = active
        )
    }
}
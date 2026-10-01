package com.faizan.workpilot.features.companyManagement.domain.usecase.admin

import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminPage
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyAdminRepository
import javax.inject.Inject

class GetCompanyAdminsUseCase @Inject constructor(
    private val repository: CompanyAdminRepository
) {

    suspend operator fun invoke(
        companyId: Long,
        page: Int,
        size: Int,
        search: String? = null
    ): CompanyAdminPage {
        return repository.getCompanyAdmins(
            companyId = companyId,
            page = page,
            size = size,
            search = search
        )
    }
}
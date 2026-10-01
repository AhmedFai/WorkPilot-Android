package com.faizan.workpilot.features.companyManagement.data.repository

import com.faizan.workpilot.features.companyManagement.data.api.CompanyManagementApi
import com.faizan.workpilot.features.companyManagement.data.mapper.toDomain
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminPage
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyAdminRepository
import javax.inject.Inject

class CompanyAdminRepositoryImpl @Inject constructor(
    private val api: CompanyManagementApi
) : CompanyAdminRepository {

    override suspend fun getCompanyAdmins(
        companyId: Long,
        page: Int,
        size: Int,
        search: String?
    ): CompanyAdminPage {
        return api.getCompanyAdmins(
            companyId = companyId,
            page = page,
            size = size,
            search = search
        ).toDomain()
    }
}
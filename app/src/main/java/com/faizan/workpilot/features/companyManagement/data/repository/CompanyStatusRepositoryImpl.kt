package com.faizan.workpilot.features.companyManagement.data.repository

import com.faizan.workpilot.features.companyManagement.data.api.CompanyManagementApi
import com.faizan.workpilot.features.companyManagement.data.mapper.toDomain
import com.faizan.workpilot.features.companyManagement.data.mapper.toRequest
import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo
import com.faizan.workpilot.features.companyManagement.domain.model.companyStatus.UpdateCompanyStatus
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyStatusRepository
import javax.inject.Inject

class CompanyStatusRepositoryImpl @Inject constructor(
    private val api: CompanyManagementApi
) : CompanyStatusRepository {

    override suspend fun updateCompanyStatus(
        companyId: Long,
        status: UpdateCompanyStatus
    ): CompanyInfo {
        return api.updateCompanyStatus(
            companyId = companyId,
            request = status.toRequest()
        ).toDomain()
    }
}
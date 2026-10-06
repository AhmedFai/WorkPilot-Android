package com.faizan.workpilot.features.companyManagement.data.repository

import com.faizan.workpilot.features.companyManagement.data.api.CompanyManagementApi
import com.faizan.workpilot.features.companyManagement.data.mapper.toDomain
import com.faizan.workpilot.features.companyManagement.data.mapper.toRequest
import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo
import com.faizan.workpilot.features.companyManagement.domain.model.editCompanyInfo.UpdateCompanyInfo
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyEditInfoRepository
import javax.inject.Inject

class CompanyEditInfoRepositoryImpl @Inject constructor(
    private val api: CompanyManagementApi
) : CompanyEditInfoRepository {

    override suspend fun updateCompany(
        companyId: Long,
        companyInfo: UpdateCompanyInfo
    ): CompanyInfo {
        return api.updateCompany(
            companyId = companyId,
            request = companyInfo.toRequest()
        ).toDomain()
    }
}
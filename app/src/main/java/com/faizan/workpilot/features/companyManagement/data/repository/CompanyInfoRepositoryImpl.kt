package com.faizan.workpilot.features.companyManagement.data.repository

import com.faizan.workpilot.features.companyManagement.data.api.CompanyManagementApi
import com.faizan.workpilot.features.companyManagement.data.mapper.toDomain
import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyInfoRepository
import javax.inject.Inject

class CompanyInfoRepositoryImpl @Inject constructor(
    private val api: CompanyManagementApi
) : CompanyInfoRepository {

    override suspend fun getCompanyInfo(
        companyId: Long
    ): CompanyInfo {
        return api.getCompanyInfo(
            companyId = companyId
        ).toDomain()
    }
}
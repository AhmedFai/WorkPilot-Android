package com.faizan.workpilot.features.companyManagement.domain.repository

import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo
import com.faizan.workpilot.features.companyManagement.domain.model.editCompanyInfo.UpdateCompanyInfo

interface CompanyEditInfoRepository {

    suspend fun updateCompany(
        companyId: Long,
        companyInfo: UpdateCompanyInfo
    ): CompanyInfo
}
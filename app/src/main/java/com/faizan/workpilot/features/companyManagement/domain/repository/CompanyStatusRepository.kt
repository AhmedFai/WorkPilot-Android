package com.faizan.workpilot.features.companyManagement.domain.repository

import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo
import com.faizan.workpilot.features.companyManagement.domain.model.companyStatus.UpdateCompanyStatus

interface CompanyStatusRepository {

    suspend fun updateCompanyStatus(
        companyId: Long,
        status: UpdateCompanyStatus
    ): CompanyInfo
}
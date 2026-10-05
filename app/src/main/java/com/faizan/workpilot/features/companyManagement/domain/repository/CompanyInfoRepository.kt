package com.faizan.workpilot.features.companyManagement.domain.repository

import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo

interface CompanyInfoRepository {

    suspend fun getCompanyInfo(
        companyId: Long
    ): CompanyInfo
}
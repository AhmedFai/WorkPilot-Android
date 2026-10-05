package com.faizan.workpilot.features.companyManagement.domain.usecase.companyInfo

import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyInfoRepository
import jakarta.inject.Inject

class GetCompanyInfoUseCase @Inject constructor(
    private val repository: CompanyInfoRepository
) {

    suspend operator fun invoke(
        companyId: Long
    ): CompanyInfo {
        return repository.getCompanyInfo(
            companyId = companyId
        )
    }
}
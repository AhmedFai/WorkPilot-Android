package com.faizan.workpilot.features.companyManagement.domain.usecase.editCompanyInfo

import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo
import com.faizan.workpilot.features.companyManagement.domain.model.editCompanyInfo.UpdateCompanyInfo
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyEditInfoRepository
import javax.inject.Inject

class UpdateCompanyInfoUseCase @Inject constructor(
    private val repository: CompanyEditInfoRepository
) {

    suspend operator fun invoke(
        companyId: Long,
        companyInfo: UpdateCompanyInfo
    ): CompanyInfo {
        return repository.updateCompany(
            companyId = companyId,
            companyInfo = companyInfo
        )
    }
}
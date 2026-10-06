package com.faizan.workpilot.features.companyManagement.domain.usecase.companyStatus

import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo
import com.faizan.workpilot.features.companyManagement.domain.model.companyStatus.UpdateCompanyStatus
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyStatusRepository
import javax.inject.Inject

class UpdateCompanyStatusUseCase @Inject constructor(
    private val repository: CompanyStatusRepository
) {

    suspend operator fun invoke(
        companyId: Long,
        status: UpdateCompanyStatus
    ): CompanyInfo {
        return repository.updateCompanyStatus(
            companyId = companyId,
            status = status
        )
    }
}
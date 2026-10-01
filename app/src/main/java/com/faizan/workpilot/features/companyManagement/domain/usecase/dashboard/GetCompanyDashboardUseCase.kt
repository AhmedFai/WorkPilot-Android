package com.faizan.workpilot.features.companyManagement.domain.usecase.dashboard

import com.faizan.workpilot.features.companyManagement.domain.model.dashboard.CompanyDashboard
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyDashboardRepository
import javax.inject.Inject

class GetCompanyDashboardUseCase @Inject constructor(
    private val repository: CompanyDashboardRepository
) {

    suspend operator fun invoke(
        companyId: Long
    ): CompanyDashboard {

        return repository.getCompanyDashboard(
            companyId
        )
    }
}
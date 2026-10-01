package com.faizan.workpilot.features.companyManagement.data.repository

import com.faizan.workpilot.features.companyManagement.data.api.CompanyManagementApi
import com.faizan.workpilot.features.companyManagement.data.mapper.toDomain
import com.faizan.workpilot.features.companyManagement.domain.model.dashboard.CompanyDashboard
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyDashboardRepository
import javax.inject.Inject

class CompanyDashboardRepositoryImpl @Inject constructor(
    private val api: CompanyManagementApi
) : CompanyDashboardRepository {

    override suspend fun getCompanyDashboard(
        companyId: Long
    ): CompanyDashboard {

        return api
            .getCompanyDashboard(companyId)
            .toDomain()
    }
}
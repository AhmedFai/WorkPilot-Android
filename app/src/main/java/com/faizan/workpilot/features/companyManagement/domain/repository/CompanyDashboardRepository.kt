package com.faizan.workpilot.features.companyManagement.domain.repository

import com.faizan.workpilot.features.companyManagement.domain.model.dashboard.CompanyDashboard

interface CompanyDashboardRepository {

    suspend fun getCompanyDashboard(
        companyId: Long
    ): CompanyDashboard
}
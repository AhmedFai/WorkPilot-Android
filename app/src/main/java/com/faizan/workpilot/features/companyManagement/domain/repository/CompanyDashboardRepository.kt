package com.faizan.workpilot.features.companyManagement.domain.repository

import com.faizan.workpilot.features.companyManagement.domain.model.CompanyDashboard

interface CompanyDashboardRepository {

    suspend fun getCompanyDashboard(
        companyId: Long
    ): CompanyDashboard
}
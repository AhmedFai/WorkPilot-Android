package com.faizan.workpilot.features.dashboard.data.repository

import com.faizan.workpilot.features.dashboard.data.api.DashboardApi
import com.faizan.workpilot.features.dashboard.data.mapper.toDomain
import com.faizan.workpilot.features.dashboard.domain.model.AdminDashboard
import com.faizan.workpilot.features.dashboard.domain.repository.DashboardRepository
import jakarta.inject.Inject

class DashboardRepositoryImpl @Inject constructor(
    private val dashboardApi: DashboardApi
) : DashboardRepository {

    override suspend fun getAdminDashboard(): AdminDashboard {

        return dashboardApi
            .getAdminDashboard()
            .data
            .toDomain()
    }
}
package com.faizan.workpilot.features.dashboard.superAdmin.data.repository

import com.faizan.workpilot.features.dashboard.superAdmin.data.api.SuperAdminDashboardApi
import com.faizan.workpilot.features.dashboard.superAdmin.data.mapper.toDomain
import com.faizan.workpilot.features.dashboard.superAdmin.domain.model.SuperAdminDashboard
import com.faizan.workpilot.features.dashboard.superAdmin.domain.repository.SuperAdminDashboardRepository
import javax.inject.Inject

class SuperAdminDashboardRepositoryImpl @Inject constructor(
    private val api: SuperAdminDashboardApi
) : SuperAdminDashboardRepository {

    override suspend fun getDashboard(): SuperAdminDashboard {
        return api.getDashboard().toDomain()
    }
}
package com.faizan.workpilot.features.dashboard.admin.data.repository

import com.faizan.workpilot.core.common.error.AppException
import com.faizan.workpilot.core.network.error.NetworkErrorHandler
import com.faizan.workpilot.features.dashboard.admin.data.api.DashboardApi
import com.faizan.workpilot.features.dashboard.admin.data.mapper.toDomain
import com.faizan.workpilot.features.dashboard.admin.domain.model.AdminDashboard
import com.faizan.workpilot.features.dashboard.admin.domain.repository.DashboardRepository
import jakarta.inject.Inject

class DashboardRepositoryImpl @Inject constructor(
    private val dashboardApi: DashboardApi,
    private val networkErrorHandler: NetworkErrorHandler
) : DashboardRepository {

    override suspend fun getAdminDashboard(): AdminDashboard {
        return try {
            dashboardApi
                .getAdminDashboard()
                .data
                .toDomain()
        } catch (exception: Exception) {
            throw AppException(
                error = networkErrorHandler.handle(
                    exception
                )
            )
        }
    }
}
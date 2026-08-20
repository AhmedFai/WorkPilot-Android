package com.faizan.workpilot.features.dashboard.data.repository

import com.faizan.workpilot.core.common.error.AppException
import com.faizan.workpilot.core.network.error.NetworkErrorHandler
import com.faizan.workpilot.features.dashboard.data.api.DashboardApi
import com.faizan.workpilot.features.dashboard.data.mapper.toDomain
import com.faizan.workpilot.features.dashboard.domain.model.AdminDashboard
import com.faizan.workpilot.features.dashboard.domain.repository.DashboardRepository
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
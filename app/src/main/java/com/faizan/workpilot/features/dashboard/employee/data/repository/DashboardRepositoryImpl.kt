package com.faizan.workpilot.features.dashboard.employee.data.repository

import com.faizan.workpilot.features.dashboard.employee.data.api.DashboardApi
import com.faizan.workpilot.features.dashboard.employee.data.mapper.toDomain
import com.faizan.workpilot.features.dashboard.employee.domain.model.EmployeeDashboard
import com.faizan.workpilot.features.dashboard.employee.domain.repository.DashboardRepository
import jakarta.inject.Inject

class DashboardRepositoryImpl @Inject constructor(
    private val dashboardApi: DashboardApi
) : DashboardRepository {

    override suspend fun getEmployeeDashboard(): EmployeeDashboard {

        return dashboardApi
            .getEmployeeDashboard()
            .data
            .toDomain()
    }
}
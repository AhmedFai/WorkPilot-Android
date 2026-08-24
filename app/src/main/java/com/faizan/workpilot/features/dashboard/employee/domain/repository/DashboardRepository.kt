package com.faizan.workpilot.features.dashboard.employee.domain.repository

import com.faizan.workpilot.features.dashboard.employee.domain.model.EmployeeDashboard

interface DashboardRepository {

    suspend fun getEmployeeDashboard(): EmployeeDashboard
}
package com.faizan.workpilot.features.dashboard.admin.domain.repository

import com.faizan.workpilot.features.dashboard.admin.domain.model.AdminDashboard

interface DashboardRepository {
    suspend fun getAdminDashboard(): AdminDashboard
}
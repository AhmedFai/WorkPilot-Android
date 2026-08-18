package com.faizan.workpilot.features.dashboard.domain.repository

import com.faizan.workpilot.features.dashboard.domain.model.AdminDashboard

interface DashboardRepository {
    suspend fun getAdminDashboard(): AdminDashboard
}
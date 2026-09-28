package com.faizan.workpilot.features.dashboard.superAdmin.domain.repository

import com.faizan.workpilot.features.dashboard.superAdmin.domain.model.SuperAdminDashboard

interface SuperAdminDashboardRepository {

    suspend fun getDashboard(): SuperAdminDashboard
}
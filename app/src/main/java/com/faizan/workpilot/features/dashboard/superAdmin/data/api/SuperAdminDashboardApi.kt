package com.faizan.workpilot.features.dashboard.superAdmin.data.api

import com.faizan.workpilot.features.dashboard.superAdmin.data.model.SuperAdminDashboardDto
import retrofit2.http.GET

interface SuperAdminDashboardApi {

    @GET("super-admin/dashboard")
    suspend fun getDashboard(): SuperAdminDashboardDto
}
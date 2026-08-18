package com.faizan.workpilot.features.dashboard.data.api

import com.faizan.workpilot.core.network.model.ApiResponse
import com.faizan.workpilot.features.dashboard.data.model.AdminDashboardDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface DashboardApi {
    @Headers("Requires-Auth: true")
    @GET("admin/dashboard")
    suspend fun getAdminDashboard(): ApiResponse<AdminDashboardDto>
}
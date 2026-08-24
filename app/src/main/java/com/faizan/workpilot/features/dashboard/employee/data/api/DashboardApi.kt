package com.faizan.workpilot.features.dashboard.employee.data.api

import com.faizan.workpilot.core.network.model.ApiResponse
import com.faizan.workpilot.features.dashboard.employee.data.model.EmployeeDashboardDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface DashboardApi {

    @Headers("Requires-Auth: true")
    @GET("employee/dashboard")
    suspend fun getEmployeeDashboard():
            ApiResponse<EmployeeDashboardDto>
}
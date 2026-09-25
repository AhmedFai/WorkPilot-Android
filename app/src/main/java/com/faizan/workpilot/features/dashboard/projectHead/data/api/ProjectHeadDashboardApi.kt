package com.faizan.workpilot.features.dashboard.projectHead.data.api

import com.faizan.workpilot.features.dashboard.projectHead.data.model.ProjectHeadDashboardDto
import retrofit2.http.GET

interface ProjectHeadDashboardApi {

    @GET("project-head/dashboard")
    suspend fun getDashboard(): ProjectHeadDashboardDto
}
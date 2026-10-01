package com.faizan.workpilot.features.companyManagement.data.api

import com.faizan.workpilot.features.companyManagement.data.model.CompanyOverviewResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CompanyManagementApi {

    @GET("companies/{companyId}/dashboard")
    suspend fun getCompanyDashboard(
        @Path("companyId") companyId: Long
    ): CompanyOverviewResponseDto
}
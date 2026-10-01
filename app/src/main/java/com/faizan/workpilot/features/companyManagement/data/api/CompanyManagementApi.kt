package com.faizan.workpilot.features.companyManagement.data.api

import com.faizan.workpilot.features.companyManagement.data.model.admin.CompanyAdminsResponseDto
import com.faizan.workpilot.features.companyManagement.data.model.dashboard.CompanyOverviewResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CompanyManagementApi {

    @GET("companies/{companyId}/dashboard")
    suspend fun getCompanyDashboard(
        @Path("companyId") companyId: Long
    ): CompanyOverviewResponseDto

    @GET("companies/{companyId}/admins")
    suspend fun getCompanyAdmins(
        @Path("companyId") companyId: Long,
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Query("search") search: String? = null
    ): CompanyAdminsResponseDto
}
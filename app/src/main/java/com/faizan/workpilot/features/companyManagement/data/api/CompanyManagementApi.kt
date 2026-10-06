package com.faizan.workpilot.features.companyManagement.data.api

import com.faizan.workpilot.features.companyManagement.data.model.admin.CompanyAdminsResponseDto
import com.faizan.workpilot.features.companyManagement.data.model.companyInfo.CompanyInfoResponseDto
import com.faizan.workpilot.features.companyManagement.data.model.dashboard.CompanyOverviewResponseDto
import com.faizan.workpilot.features.companyManagement.data.model.editCompanyInfo.UpdateCompanyRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
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

    @GET("companies/{companyId}")
    suspend fun getCompanyInfo(
        @Path("companyId") companyId: Long
    ): CompanyInfoResponseDto

    @PUT("companies/{companyId}")
    suspend fun updateCompany(
        @Path("companyId") companyId: Long,
        @Body request: UpdateCompanyRequest
    ): CompanyInfoResponseDto
}
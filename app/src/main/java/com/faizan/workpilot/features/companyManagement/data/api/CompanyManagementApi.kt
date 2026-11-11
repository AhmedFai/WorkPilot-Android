package com.faizan.workpilot.features.companyManagement.data.api

import com.faizan.workpilot.features.companyManagement.data.model.admin.CompanyAdminDetailsResponseDto
import com.faizan.workpilot.features.companyManagement.data.model.admin.CompanyAdminsResponseDto
import com.faizan.workpilot.features.companyManagement.data.model.admin.CreateCompanyAdminRequestDto
import com.faizan.workpilot.features.companyManagement.data.model.admin.CreateCompanyAdminResponseDto
import com.faizan.workpilot.features.companyManagement.data.model.admin.UpdateAdminStatusRequestDto
import com.faizan.workpilot.features.companyManagement.data.model.admin.UpdateCompanyAdminRequestDto
import com.faizan.workpilot.features.companyManagement.data.model.companyInfo.CompanyInfoResponseDto
import com.faizan.workpilot.features.companyManagement.data.model.companyStatus.UpdateCompanyStatusRequest
import com.faizan.workpilot.features.companyManagement.data.model.dashboard.CompanyOverviewResponseDto
import com.faizan.workpilot.features.companyManagement.data.model.editCompanyInfo.UpdateCompanyRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
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

    // Create Company Admin
    @POST("companies/{companyId}/admins")
    suspend fun createCompanyAdmin(
        @Path("companyId") companyId: Long,
        @Body request: CreateCompanyAdminRequestDto
    ): CreateCompanyAdminResponseDto

    // Get Company Admin Details
    @GET("companies/{companyId}/admins/{adminId}")
    suspend fun getCompanyAdminDetails(
        @Path("companyId") companyId: Long,
        @Path("adminId") adminId: Long
    ): CompanyAdminDetailsResponseDto

    // Activate / Deactivate Company Admin
    @PATCH("companies/{companyId}/admins/{adminId}/status")
    suspend fun updateCompanyAdminStatus(
        @Path("companyId") companyId: Long,
        @Path("adminId") adminId: Long,
        @Body request: UpdateAdminStatusRequestDto
    ): CompanyAdminDetailsResponseDto

    @GET("companies/{companyId}")
    suspend fun getCompanyInfo(
        @Path("companyId") companyId: Long
    ): CompanyInfoResponseDto

    @PUT("companies/{companyId}")
    suspend fun updateCompany(
        @Path("companyId") companyId: Long,
        @Body request: UpdateCompanyRequest
    ): CompanyInfoResponseDto

    @PATCH("companies/{companyId}/status")
    suspend fun updateCompanyStatus(
        @Path("companyId") companyId: Long,
        @Body request: UpdateCompanyStatusRequest
    ): CompanyInfoResponseDto

    // Update Company Admin
    @PATCH("companies/{companyId}/admins/{adminId}")
    suspend fun updateCompanyAdmin(
        @Path("companyId") companyId: Long,
        @Path("adminId") adminId: Long,
        @Body request: UpdateCompanyAdminRequestDto
    ): CompanyAdminDetailsResponseDto

}
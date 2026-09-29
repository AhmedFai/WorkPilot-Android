package com.faizan.workpilot.features.company.data.api

import com.faizan.workpilot.features.company.data.model.CreateCompanyRequestDto
import com.faizan.workpilot.features.company.data.model.CreateCompanyResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface CompanyApi {

    @POST("companies")
    suspend fun createCompany(
        @Body request: CreateCompanyRequestDto
    ): CreateCompanyResponseDto
}
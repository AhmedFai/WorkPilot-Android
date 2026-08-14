package com.faizan.workpilot.core.network.api

import com.faizan.workpilot.core.network.model.ApiResponse
import com.faizan.workpilot.features.login.data.model.RefreshTokenRequestDto
import com.faizan.workpilot.features.login.data.model.RefreshTokenResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface RefreshApi {

    @POST("auth/refresh")
    suspend fun refreshToken(
        @Body request: RefreshTokenRequestDto
    ): ApiResponse<RefreshTokenResponseDto>
}
package com.faizan.workpilot.core.network.api

import com.faizan.workpilot.core.network.model.ApiResponse
import com.faizan.workpilot.features.login.data.model.LoginRequestDto
import com.faizan.workpilot.features.login.data.model.LoginResponseDto
import com.faizan.workpilot.features.login.data.model.RefreshTokenRequestDto
import com.faizan.workpilot.features.login.data.model.RefreshTokenResponseDto
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApi {

    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequestDto
    ): ApiResponse<LoginResponseDto>

    //@Headers("Requires-Auth: true")

}
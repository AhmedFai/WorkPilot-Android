package com.faizan.workpilot.features.login.data.repository

import com.faizan.workpilot.core.network.api.AuthApi
import com.faizan.workpilot.features.login.data.mapper.toDomain
import com.faizan.workpilot.features.login.data.mapper.toDto
import com.faizan.workpilot.features.login.domain.model.LoginRequest
import com.faizan.workpilot.features.login.domain.model.LoginResult
import com.faizan.workpilot.features.login.domain.repository.LoginRepository
import jakarta.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : LoginRepository {

    override suspend fun login(
        request: LoginRequest
    ): LoginResult {

        val response = authApi.login(
            request = request.toDto()
        )

        return response.data.toDomain(
            message = response.message
        )
    }
}
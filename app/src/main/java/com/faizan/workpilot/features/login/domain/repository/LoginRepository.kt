package com.faizan.workpilot.features.login.domain.repository

import com.faizan.workpilot.features.login.domain.model.LoginRequest
import com.faizan.workpilot.features.login.domain.model.LoginResult

interface LoginRepository {

    suspend fun login(
        request: LoginRequest
    ): LoginResult
}
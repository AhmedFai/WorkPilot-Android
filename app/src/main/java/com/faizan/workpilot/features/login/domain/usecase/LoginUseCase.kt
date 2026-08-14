package com.faizan.workpilot.features.login.domain.usecase

import com.faizan.workpilot.features.login.domain.model.LoginRequest
import com.faizan.workpilot.features.login.domain.model.LoginResult
import com.faizan.workpilot.features.login.domain.repository.LoginRepository
import jakarta.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(
        request: LoginRequest
    ): LoginResult {
        return loginRepository.login(request)
    }
}
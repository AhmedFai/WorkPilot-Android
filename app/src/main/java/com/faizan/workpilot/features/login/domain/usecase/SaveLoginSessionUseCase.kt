package com.faizan.workpilot.features.login.domain.usecase

import com.faizan.workpilot.core.datastore.TokenStorage
import com.faizan.workpilot.core.datastore.UserSessionStorage
import com.faizan.workpilot.features.login.domain.model.LoginResult
import jakarta.inject.Inject

class SaveLoginSessionUseCase @Inject constructor(
    private val tokenStorage: TokenStorage,
    private val userSessionStorage: UserSessionStorage
) {

    suspend operator fun invoke(
        loginResult: LoginResult
    ) {
        tokenStorage.saveTokens(
            accessToken = loginResult.accessToken,
            refreshToken = loginResult.refreshToken
        )

        userSessionStorage.saveUserSession(
            loginResult.user
        )
    }
}
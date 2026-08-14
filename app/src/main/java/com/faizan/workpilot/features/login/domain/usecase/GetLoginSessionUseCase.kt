package com.faizan.workpilot.features.login.domain.usecase

import com.faizan.workpilot.core.datastore.TokenStorage
import com.faizan.workpilot.core.datastore.UserSessionStorage
import com.faizan.workpilot.features.login.domain.model.UserSession
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

data class LoginSession(
    val accessToken: String,
    val refreshToken: String,
    val user: UserSession
)

class GetLoginSessionUseCase @Inject constructor(
    private val tokenStorage: TokenStorage,
    private val userSessionStorage: UserSessionStorage
) {

    operator fun invoke(): Flow<LoginSession?> {

        return combine(
            tokenStorage.accessToken,
            tokenStorage.refreshToken,
            userSessionStorage.userSession
        ) { accessToken, refreshToken, user ->

            if (
                accessToken.isNullOrBlank() ||
                refreshToken.isNullOrBlank() ||
                user == null
            ) {
                null
            } else {
                LoginSession(
                    accessToken = accessToken,
                    refreshToken = refreshToken,
                    user = user
                )
            }
        }
    }
}
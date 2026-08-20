package com.faizan.workpilot.core.network.authenticator

import com.faizan.workpilot.core.datastore.TokenStorage
import com.faizan.workpilot.core.datastore.UserSessionStorage
import com.faizan.workpilot.core.network.api.RefreshApi
import com.faizan.workpilot.features.login.data.model.RefreshTokenRequestDto
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class AuthAuthenticator @Inject constructor(
    private val tokenStorage: TokenStorage,
    private val userSessionStorage: UserSessionStorage,
    private val refreshApi: RefreshApi
) : Authenticator {

    override fun authenticate(
        route: Route?,
        response: Response
    ): Request? {

        if (responseCount(response) >= 2) {
            return null
        }

        return runBlocking {

            val refreshToken =
                tokenStorage.refreshToken.first()

            if (refreshToken.isNullOrBlank()) {

                tokenStorage.clearTokens()
                userSessionStorage.clearUserSession()

                return@runBlocking null
            }

            try {

                val refreshResponse =
                    refreshApi.refreshToken(
                        RefreshTokenRequestDto(
                            refreshToken = refreshToken
                        )
                    )

                val newAccessToken =
                    refreshResponse.data.accessToken

                if (newAccessToken.isBlank()) {

                    tokenStorage.clearTokens()
                    userSessionStorage.clearUserSession()

                    return@runBlocking null
                }

                tokenStorage.updateAccessToken(
                    newAccessToken
                )

                response.request
                    .newBuilder()
                    .header(
                        "Authorization",
                        "Bearer $newAccessToken"
                    )
                    .build()

            } catch (_: Exception) {

                tokenStorage.clearTokens()
                userSessionStorage.clearUserSession()

                null
            }
        }
    }

    private fun responseCount(
        response: Response
    ): Int {

        var count = 1
        var priorResponse = response.priorResponse

        while (priorResponse != null) {
            count++
            priorResponse = priorResponse.priorResponse
        }

        return count
    }
}
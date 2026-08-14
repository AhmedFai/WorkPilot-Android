package com.faizan.workpilot.core.network.interceptor

import com.faizan.workpilot.core.datastore.TokenStorage
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenStorage: TokenStorage
) : Interceptor {

    override fun intercept(
        chain: Interceptor.Chain
    ): Response {

        val request = chain.request()

        val requiresAuthentication =
            request.header(REQUIRES_AUTH_HEADER) == "true"

        if (!requiresAuthentication) {
            return chain.proceed(request)
        }

        val accessToken =
            tokenStorage.getAccessToken()

        val authenticatedRequest =
            if (!accessToken.isNullOrBlank()) {

                request.newBuilder()
                    .addHeader(
                        "Authorization",
                        "Bearer $accessToken"
                    )
                    .removeHeader(REQUIRES_AUTH_HEADER)
                    .build()

            } else {

                request.newBuilder()
                    .removeHeader(REQUIRES_AUTH_HEADER)
                    .build()
            }

        return chain.proceed(authenticatedRequest)
    }

    companion object {
        const val REQUIRES_AUTH_HEADER = "Requires-Auth"
    }
}
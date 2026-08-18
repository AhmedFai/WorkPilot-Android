package com.faizan.workpilot.core.network.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer
import java.nio.charset.Charset

object NetworkLoggingInterceptor {

    fun create(): Interceptor {

        return Interceptor { chain ->

            val request = chain.request()

            val requestBody = request.body

            val requestBodyText =
                if (requestBody != null) {
                    try {
                        val buffer = Buffer()
                        requestBody.writeTo(buffer)

                        buffer.readString(
                            Charset.forName("UTF-8")
                        )
                    } catch (_: Exception) {
                        "[Unable to read request body]"
                    }
                } else {
                    ""
                }

            Log.d(
                TAG,
                """
                ─────────── API REQUEST ───────────
                URL: ${request.url}
                Method: ${request.method}
                Headers: ${request.headers}
                Body: ${redactSensitiveData(requestBodyText)}
                ──────────────────────────────────
                """.trimIndent()
            )

            val response = try {
                chain.proceed(request)
            } catch (exception: Exception) {

                Log.e(
                    TAG,
                    "API EXCEPTION: ${exception.message}",
                    exception
                )

                throw exception
            }

            val responseBody = try {
                response.peekBody(
                    MAX_RESPONSE_BODY_SIZE
                ).string()
            } catch (_: Exception) {
                "[Unable to read response body]"
            }

            Log.d(
                TAG,
                """
                ─────────── API RESPONSE ──────────
                URL: ${response.request.url}
                Status: ${response.code}
                Message: ${response.message}
                Body: ${redactSensitiveData(responseBody)}
                ──────────────────────────────────
                """.trimIndent()
            )

            response
        }
    }

    private fun redactSensitiveData(
        data: String
    ): String {

        if (data.isBlank()) {
            return data
        }

        return data
            .replace(
                Regex(
                    """"password"\s*:\s*"[^"]*"""",
                    RegexOption.IGNORE_CASE
                ),
                """"password":"[REDACTED]""""
            )
            .replace(
                Regex(
                    """"accessToken"\s*:\s*"[^"]*"""",
                    RegexOption.IGNORE_CASE
                ),
                """"accessToken":"[REDACTED]""""
            )
            .replace(
                Regex(
                    """"refreshToken"\s*:\s*"[^"]*"""",
                    RegexOption.IGNORE_CASE
                ),
                """"refreshToken":"[REDACTED]""""
            )
    }

    private const val TAG = "Network"
    private const val MAX_RESPONSE_BODY_SIZE = 1024L * 1024L
}
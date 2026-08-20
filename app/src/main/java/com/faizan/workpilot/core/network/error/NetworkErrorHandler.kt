package com.faizan.workpilot.core.network.error

import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.core.network.connectivity.NetworkConnectivityChecker
import jakarta.inject.Inject
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

class NetworkErrorHandler @Inject constructor(
    private val networkConnectivityChecker: NetworkConnectivityChecker
) {

    fun handle(
        exception: Exception
    ): NetworkError {

        if (exception is HttpException) {

            val errorBody = exception
                .response()
                ?.errorBody()
                ?.string()

            if (!errorBody.isNullOrBlank()) {

                try {

                    val jsonObject =
                        JSONObject(errorBody)

                    val message = jsonObject
                        .optString("message")
                        .takeIf { it.isNotBlank() }

                    if (message != null) {

                        return NetworkError(
                            type = exception.code()
                                .toNetworkErrorType(),
                            message = UiText.Dynamic(message)
                        )
                    }

                } catch (_: Exception) {
                    // fallback
                }
            }

            return NetworkError(
                type = exception.code()
                    .toNetworkErrorType(),
                message = when (exception.code()) {

                    400 -> UiText.StringRes(
                        R.string.error_bad_request
                    )

                    401 -> UiText.StringRes(
                        R.string.error_unauthorized
                    )

                    403 -> UiText.StringRes(
                        R.string.error_access_denied
                    )

                    404 -> UiText.StringRes(
                        R.string.error_not_found
                    )

                    409 -> UiText.StringRes(
                        R.string.error_conflict
                    )

                    in 500..599 -> UiText.StringRes(
                        R.string.error_server
                    )

                    else -> UiText.StringRes(
                        R.string.error_request_failed
                    )
                }
            )
        }

        if (exception is IOException) {

            return if (
                networkConnectivityChecker.isConnected()
            ) {

                NetworkError(
                    type = NetworkErrorType.UNKNOWN,
                    message = UiText.StringRes(
                        R.string.error_request_failed
                    )
                )

            } else {

                NetworkError(
                    type = NetworkErrorType.NO_CONNECTION,
                    message = UiText.StringRes(
                        R.string.error_no_connection
                    )
                )
            }
        }

        return NetworkError(
            type = NetworkErrorType.UNKNOWN,
            message = UiText.StringRes(
                R.string.error_unknown
            )
        )
    }
}
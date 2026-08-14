package com.faizan.workpilot.core.network.error

import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

object NetworkErrorHandler {

    fun getMessage(
        exception: Exception
    ): UiText {

        if (exception is HttpException) {

            val errorBody = exception
                .response()
                ?.errorBody()
                ?.string()

            if (!errorBody.isNullOrBlank()) {

                try {

                    val jsonObject = JSONObject(errorBody)

                    val message = jsonObject
                        .optString("message")
                        .takeIf { it.isNotBlank() }

                    if (message != null) {
                        return UiText.Dynamic(message)
                    }

                } catch (_: Exception) {
                    // Fall back to HTTP status message
                }
            }

            return when (exception.code()) {

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

                500 -> UiText.StringRes(
                    R.string.error_server
                )

                else -> UiText.StringRes(
                    R.string.error_request_failed
                )
            }
        }

        if (exception is IOException) {
            return UiText.StringRes(
                R.string.error_no_connection
            )
        }

        return UiText.StringRes(
            R.string.error_unknown
        )
    }
}
package com.faizan.workpilot.core.network.error

fun Int.toNetworkErrorType(): NetworkErrorType {

    return when (this) {

        400 -> NetworkErrorType.BAD_REQUEST
        401 -> NetworkErrorType.UNAUTHORIZED
        403 -> NetworkErrorType.FORBIDDEN
        404 -> NetworkErrorType.NOT_FOUND
        409 -> NetworkErrorType.CONFLICT

        in 500..599 ->
            NetworkErrorType.SERVER_ERROR

        else ->
            NetworkErrorType.UNKNOWN
    }
}
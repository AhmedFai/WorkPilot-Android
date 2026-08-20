package com.faizan.workpilot.core.common.error

import com.faizan.workpilot.core.network.error.NetworkError

class AppException(
    val error: NetworkError
) : Exception()
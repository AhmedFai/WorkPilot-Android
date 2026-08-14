package com.faizan.workpilot.core.network.model

data class ApiResponse<T>(
    val message: String,
    val data: T
)

package com.faizan.workpilot.core.network.interceptor

import okhttp3.logging.HttpLoggingInterceptor

object NetworkLoggingInterceptor {

    fun create(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}
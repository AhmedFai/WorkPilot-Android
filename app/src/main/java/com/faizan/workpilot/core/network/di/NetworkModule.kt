package com.faizan.workpilot.core.network.di

import com.faizan.workpilot.core.network.api.AuthApi
import com.faizan.workpilot.core.network.api.RefreshApi
import com.faizan.workpilot.core.network.authenticator.AuthAuthenticator
import com.faizan.workpilot.core.network.interceptor.AuthInterceptor
import com.faizan.workpilot.core.network.interceptor.NetworkLoggingInterceptor
import com.faizan.workpilot.features.dashboard.admin.data.api.DashboardApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL =
        "http://localhost:8080/api/v1/"

    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
        authAuthenticator: AuthAuthenticator
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .authenticator(authAuthenticator)
            .addInterceptor(
                NetworkLoggingInterceptor.create()
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthApi(
        retrofit: Retrofit
    ): AuthApi {

        return retrofit.create(
            AuthApi::class.java
        )
    }

    @Provides
    @Singleton
    fun provideRefreshApi(): RefreshApi {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()

        return retrofit.create(
            RefreshApi::class.java
        )
    }

    @Provides
    @Singleton
    fun provideDashboardApi(
        retrofit: Retrofit
    ): DashboardApi {

        return retrofit.create(
            DashboardApi::class.java
        )
    }

}
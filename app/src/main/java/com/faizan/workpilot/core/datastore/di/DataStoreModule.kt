package com.faizan.workpilot.core.datastore.di

import android.content.Context
import com.faizan.workpilot.core.datastore.TokenStorage
import com.faizan.workpilot.core.datastore.UserSessionStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideTokenStorage(
        @ApplicationContext context: Context
    ): TokenStorage {
        return TokenStorage(context)
    }

    @Provides
    @Singleton
    fun provideUserSessionStorage(
        @ApplicationContext context: Context
    ): UserSessionStorage {
        return UserSessionStorage(context)
    }
}
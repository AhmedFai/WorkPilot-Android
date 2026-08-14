package com.faizan.workpilot.features.login.data.di

import com.faizan.workpilot.features.login.domain.repository.LoginRepository
import com.faizan.workpilot.features.login.data.repository.LoginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoginModule {

    @Binds
    @Singleton
    abstract fun bindLoginRepository(
        implementation: LoginRepositoryImpl
    ): LoginRepository
}
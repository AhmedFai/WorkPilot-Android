package com.faizan.workpilot.features.dashboard.data.di

import com.faizan.workpilot.features.dashboard.data.repository.DashboardRepositoryImpl
import com.faizan.workpilot.features.dashboard.domain.repository.DashboardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DashboardModule {

    @Binds
    @Singleton
    abstract fun bindDashboardRepository(
        implementation: DashboardRepositoryImpl
    ): DashboardRepository
}
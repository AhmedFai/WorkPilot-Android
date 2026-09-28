package com.faizan.workpilot.features.dashboard.superAdmin.data.di

import com.faizan.workpilot.features.dashboard.superAdmin.data.repository.SuperAdminDashboardRepositoryImpl
import com.faizan.workpilot.features.dashboard.superAdmin.domain.repository.SuperAdminDashboardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SuperAdminDashboardModule {

    @Binds
    @Singleton
    abstract fun bindSuperAdminDashboardRepository(
        implementation: SuperAdminDashboardRepositoryImpl
    ): SuperAdminDashboardRepository
}
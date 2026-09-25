package com.faizan.workpilot.features.dashboard.projectHead.data.di

import com.faizan.workpilot.features.dashboard.projectHead.data.repository.ProjectHeadDashboardRepositoryImpl
import com.faizan.workpilot.features.dashboard.projectHead.domain.repository.ProjectHeadDashboardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProjectHeadDashboardModule {

    @Binds
    @Singleton
    abstract fun bindProjectHeadDashboardRepository(
        implementation: ProjectHeadDashboardRepositoryImpl
    ): ProjectHeadDashboardRepository
}
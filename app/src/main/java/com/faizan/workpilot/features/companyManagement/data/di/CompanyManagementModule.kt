package com.faizan.workpilot.features.companyManagement.data.di

import com.faizan.workpilot.features.companyManagement.data.repository.CompanyDashboardRepositoryImpl
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyDashboardRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
import com.faizan.workpilot.features.companyManagement.data.api.CompanyManagementApi

@Module
@InstallIn(SingletonComponent::class)
abstract class CompanyManagementModule {

    @Binds
    @Singleton
    abstract fun bindCompanyDashboardRepository(
        repository: CompanyDashboardRepositoryImpl
    ): CompanyDashboardRepository
}
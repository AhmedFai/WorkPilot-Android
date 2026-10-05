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
import com.faizan.workpilot.features.companyManagement.data.repository.CompanyAdminRepositoryImpl
import com.faizan.workpilot.features.companyManagement.data.repository.CompanyInfoRepositoryImpl
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyAdminRepository
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyInfoRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class CompanyManagementModule {

    @Binds
    @Singleton
    abstract fun bindCompanyDashboardRepository(
        repository: CompanyDashboardRepositoryImpl
    ): CompanyDashboardRepository

    @Binds
    @Singleton
    abstract fun bindCompanyAdminRepository(
        repository: CompanyAdminRepositoryImpl
    ): CompanyAdminRepository

    @Binds
    @Singleton
    abstract fun bindCompanyInfoRepository(
        repository: CompanyInfoRepositoryImpl
    ): CompanyInfoRepository
}
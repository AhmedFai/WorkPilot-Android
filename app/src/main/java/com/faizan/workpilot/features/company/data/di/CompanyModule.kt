package com.faizan.workpilot.features.company.data.di

import com.faizan.workpilot.features.company.data.repository.CompanyRepositoryImpl
import com.faizan.workpilot.features.company.domain.repository.CompanyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CompanyModule {

    @Binds
    @Singleton
    abstract fun bindCompanyRepository(
        implementation: CompanyRepositoryImpl
    ): CompanyRepository
}
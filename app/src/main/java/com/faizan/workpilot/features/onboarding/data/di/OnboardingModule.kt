package com.faizan.workpilot.features.onboarding.data.di

import android.content.Context
import com.faizan.workpilot.features.onboarding.data.local.OnboardingPreferences
import com.faizan.workpilot.features.onboarding.data.repository.OnboardingRepositoryImpl
import com.faizan.workpilot.features.onboarding.domain.repository.OnboardingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnboardingModule {

    @Provides
    @Singleton
    fun provideOnboardingPreferences(
        @ApplicationContext context: Context
    ): OnboardingPreferences {
        return OnboardingPreferences(context)
    }

    @Provides
    @Singleton
    fun provideOnboardingRepository(
        onboardingPreferences: OnboardingPreferences
    ): OnboardingRepository  {
        return OnboardingRepositoryImpl(onboardingPreferences)
    }

}
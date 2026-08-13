package com.faizan.workpilot.features.onboarding.data.repository

import com.faizan.workpilot.features.onboarding.data.local.OnboardingPreferences
import com.faizan.workpilot.features.onboarding.domain.repository.OnboardingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OnboardingRepositoryImpl @Inject constructor(
    private val onboardingPreferences: OnboardingPreferences
): OnboardingRepository {
    override val isOnboardingCompleted: Flow<Boolean>
        get() = onboardingPreferences.isOnboardingCompleted

    override suspend fun completeOnboarding() {
        onboardingPreferences.completeOnboarding()
    }
}
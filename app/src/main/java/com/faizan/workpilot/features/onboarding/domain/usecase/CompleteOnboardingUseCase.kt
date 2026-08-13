package com.faizan.workpilot.features.onboarding.domain.usecase

import com.faizan.workpilot.features.onboarding.domain.repository.OnboardingRepository
import javax.inject.Inject

class CompleteOnboardingUseCase @Inject constructor(
    private val repository: OnboardingRepository
) {

    suspend operator fun invoke() {
        repository.completeOnboarding()
    }
}
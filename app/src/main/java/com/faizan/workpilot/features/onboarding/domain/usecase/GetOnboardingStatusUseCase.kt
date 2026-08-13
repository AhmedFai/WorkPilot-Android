package com.faizan.workpilot.features.onboarding.domain.usecase

import com.faizan.workpilot.features.onboarding.domain.repository.OnboardingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOnboardingStatusUseCase @Inject constructor(
    private val repository: OnboardingRepository
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.isOnboardingCompleted
    }
}
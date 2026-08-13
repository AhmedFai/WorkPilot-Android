package com.faizan.workpilot.features.onboarding.domain.repository

import kotlinx.coroutines.flow.Flow

interface OnboardingRepository {
    val isOnboardingCompleted: Flow<Boolean>

    suspend fun completeOnboarding()
}
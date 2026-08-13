package com.faizan.workpilot.features.onboarding.data.local

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.onboardingDataStore by preferencesDataStore(
    name = "onboarding_preferences"
)

class OnboardingPreferences(
    private val context: Context
) {

    private companion object {
        val ONBOARDING_COMPLETED =
            booleanPreferencesKey("onboarding_completed")
    }

    val isOnboardingCompleted: Flow<Boolean> =
        context.onboardingDataStore.data.map { preferences ->
            preferences[ONBOARDING_COMPLETED] ?: false
        }

    suspend fun completeOnboarding() {
        context.onboardingDataStore.edit { preferences ->
            preferences[ONBOARDING_COMPLETED] = true
        }
    }
}
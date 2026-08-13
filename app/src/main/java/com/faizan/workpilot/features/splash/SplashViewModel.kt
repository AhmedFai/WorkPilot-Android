package com.faizan.workpilot.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.features.onboarding.domain.usecase.GetOnboardingStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getOnboardingStatusUseCase: GetOnboardingStatusUseCase
) : ViewModel() {

    private val _isOnboardingCompleted =
        MutableStateFlow<Boolean?>(null)

    val isOnboardingCompleted: StateFlow<Boolean?> =
        _isOnboardingCompleted.asStateFlow()

    init {
        observeOnboardingStatus()
    }

    private fun observeOnboardingStatus() {
        viewModelScope.launch {
            getOnboardingStatusUseCase()
                .collect { isCompleted ->
                    _isOnboardingCompleted.value = isCompleted
                }
        }
    }
}
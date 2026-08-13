package com.faizan.workpilot.features.onboarding.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.features.onboarding.domain.usecase.CompleteOnboardingUseCase
import com.faizan.workpilot.features.onboarding.domain.usecase.GetOnboardingStatusUseCase
import com.faizan.workpilot.features.onboarding.presentation.state.OnboardingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val getOnboardingStatusUseCase: GetOnboardingStatusUseCase,
    private val completeOnboardingUseCase: CompleteOnboardingUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(
        OnboardingUiState()
    )

    val uiState: StateFlow<OnboardingUiState> =
        _uiState.asStateFlow()

    private val _onboardingCompleted = MutableSharedFlow<Unit>(
        extraBufferCapacity = 1
    )

    val onboardingCompleted: SharedFlow<Unit> =
        _onboardingCompleted.asSharedFlow()

    init {
        observeOnboardingStatus()
    }

    private fun observeOnboardingStatus() {
        viewModelScope.launch {
            getOnboardingStatusUseCase()
                .collect { isCompleted ->

                    _uiState.value = OnboardingUiState(
                        isOnboardingCompleted = isCompleted,
                        isLoading = false
                    )
                }
        }
    }

    fun completeOnboarding() {
        viewModelScope.launch {
            completeOnboardingUseCase()
            _onboardingCompleted.emit(Unit)
        }
    }

}
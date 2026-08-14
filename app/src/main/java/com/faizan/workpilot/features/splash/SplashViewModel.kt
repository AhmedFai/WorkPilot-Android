package com.faizan.workpilot.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.features.login.domain.usecase.GetLoginSessionUseCase
import com.faizan.workpilot.features.onboarding.domain.usecase.GetOnboardingStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getOnboardingStatusUseCase: GetOnboardingStatusUseCase,
    private val getLoginSessionUseCase: GetLoginSessionUseCase
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(SplashUiState())

    val uiState: StateFlow<SplashUiState> =
        _uiState.asStateFlow()

    init {
        observeAppState()
    }

    private fun observeAppState() {

        viewModelScope.launch {

            combine(
                getOnboardingStatusUseCase(),
                getLoginSessionUseCase()
            ) { isOnboardingCompleted, loginSession ->

                SplashUiState(
                    isOnboardingCompleted = isOnboardingCompleted,
                    isLoggedIn = loginSession != null,
                    isReady = true
                )

            }.collect { state ->

                _uiState.value = state
            }
        }
    }
}
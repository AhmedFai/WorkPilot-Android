package com.faizan.workpilot.core.session

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.features.login.domain.usecase.GetLoginSessionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class SessionViewModel @Inject constructor(
    getLoginSessionUseCase: GetLoginSessionUseCase
) : ViewModel() {

    val isLoggedIn: StateFlow<Boolean> =
        getLoginSessionUseCase()
            .map { session ->
                session != null
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = true
            )
}
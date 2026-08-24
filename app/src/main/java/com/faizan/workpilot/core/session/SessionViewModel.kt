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

    private val loginSession =
        getLoginSessionUseCase()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = null
            )

    val isLoggedIn: StateFlow<Boolean> =
        loginSession
            .map { session ->
                session != null
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = true
            )

    val userRole: StateFlow<String?> =
        loginSession
            .map { session ->
                session?.user?.role
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = null
            )
}
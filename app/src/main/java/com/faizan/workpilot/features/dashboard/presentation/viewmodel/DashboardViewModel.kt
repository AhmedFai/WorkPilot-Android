package com.faizan.workpilot.features.dashboard.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.features.dashboard.domain.usecase.GetAdminDashboardUseCase
import com.faizan.workpilot.features.dashboard.presentation.mapper.toUiState
import com.faizan.workpilot.features.dashboard.presentation.model.DashboardUiState
import com.faizan.workpilot.features.login.domain.usecase.GetLoginSessionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalTime
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getAdminDashboardUseCase: GetAdminDashboardUseCase,
    private val getLoginSessionUseCase: GetLoginSessionUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        DashboardUiState()
    )

    val uiState: StateFlow<DashboardUiState> =
        _uiState.asStateFlow()

    init {
        loadUserSession()
        loadDashboard()
    }

    private fun loadUserSession() {

        viewModelScope.launch {

            val session =
                getLoginSessionUseCase().first()

            session?.let { loginSession ->

                _uiState.update {
                    it.copy(
                        greeting = getGreeting(),
                        userName = buildUserName(
                            loginSession.user.firstName,
                            loginSession.user.lastName
                        )
                    )
                }
            }
        }
    }

    private fun loadDashboard() {

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            delay(5000)

            try {

                val dashboard =
                    getAdminDashboardUseCase()

                _uiState.update {
                    dashboard.toUiState(it).copy(
                        isLoading = false,
                        error = null
                    )
                }

            } catch (exception: Exception) {

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun buildUserName(
        firstName: String,
        lastName: String
    ): String {

        return listOf(
            firstName,
            lastName
        )
            .filter {
                it.isNotBlank()
            }
            .joinToString(" ")
    }

    private fun getGreeting(): UiText {

        return when (LocalTime.now().hour) {
            in 5..11 -> UiText.StringRes(
                R.string.dashboard_greeting_morning
            )

            in 12..16 -> UiText.StringRes(
                R.string.dashboard_greeting_afternoon
            )

            in 17..20 -> UiText.StringRes(
                R.string.dashboard_greeting_evening
            )

            else -> UiText.StringRes(
                R.string.dashboard_greeting_night
            )
        }
    }

}
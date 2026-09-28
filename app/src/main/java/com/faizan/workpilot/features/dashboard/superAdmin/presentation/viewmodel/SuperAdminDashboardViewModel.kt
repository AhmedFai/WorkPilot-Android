package com.faizan.workpilot.features.dashboard.superAdmin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.core.network.error.NetworkErrorHandler
import com.faizan.workpilot.features.dashboard.superAdmin.domain.usecase.SuperAdminDashboardUseCase
import com.faizan.workpilot.features.dashboard.superAdmin.presentation.model.SuperAdminDashboardUiState
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.features.login.domain.usecase.GetLoginSessionUseCase
import kotlinx.coroutines.flow.first
import java.time.LocalTime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperAdminDashboardViewModel @Inject constructor(
    private val superAdminDashboardUseCase: SuperAdminDashboardUseCase,
    private val getLoginSessionUseCase: GetLoginSessionUseCase,
    private val networkErrorHandler: NetworkErrorHandler
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            SuperAdminDashboardUiState()
        )

    val uiState: StateFlow<SuperAdminDashboardUiState> =
        _uiState.asStateFlow()

    init {
        loadUserSession()
        getDashboard()
    }

    fun retry() {
        getDashboard()
    }

    private fun getDashboard() {
        if (_uiState.value.isLoading) return

        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val dashboard = superAdminDashboardUseCase()

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = null,
                        companies = dashboard.companies
                    )
                }
            } catch (exception: Exception) {
                val error = networkErrorHandler.handle(exception)

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = error
                    )
                }
            }
        }
    }

    private fun loadUserSession() {
        viewModelScope.launch {
            val session = getLoginSessionUseCase().first()

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

    private fun buildUserName(
        firstName: String,
        lastName: String
    ): String {
        return listOf(firstName, lastName)
            .filter { it.isNotBlank() }
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
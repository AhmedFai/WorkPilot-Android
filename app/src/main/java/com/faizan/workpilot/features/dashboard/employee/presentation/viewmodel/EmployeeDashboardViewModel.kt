package com.faizan.workpilot.features.dashboard.employee.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.core.network.error.NetworkErrorHandler
import com.faizan.workpilot.features.dashboard.employee.domain.usecase.GetEmployeeDashboardUseCase
import com.faizan.workpilot.features.dashboard.employee.presentation.model.EmployeeDashboardUiState
import com.faizan.workpilot.features.login.domain.usecase.GetLoginSessionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalTime

@HiltViewModel
class EmployeeDashboardViewModel @Inject constructor(
    private val getEmployeeDashboardUseCase: GetEmployeeDashboardUseCase,
    private val getLoginSessionUseCase: GetLoginSessionUseCase,
    private val networkErrorHandler: NetworkErrorHandler
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            EmployeeDashboardUiState()
        )

    val uiState: StateFlow<EmployeeDashboardUiState> =
        _uiState.asStateFlow()

    init {
        loadUserSession()
        loadDashboard()
    }

    fun retry() {
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
                    getEmployeeDashboardUseCase()

                _uiState.update {

                    it.copy(
                        isLoading = false,
                        error = null,
                        myTaskCount =
                            dashboard.myTaskCount,
                        completedTaskCount =
                            dashboard.completedTaskCount,
                        pendingTaskCount =
                            dashboard.pendingTaskCount,
                        todayTasks =
                            dashboard.todayTasks
                    )
                }

            } catch (exception: Exception) {

                val error =
                    networkErrorHandler.handle(
                        exception
                    )

                _uiState.update {

                    it.copy(
                        isLoading = false,
                        error = error
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

            in 5..11 ->
                UiText.StringRes(
                    R.string.dashboard_greeting_morning
                )

            in 12..16 ->
                UiText.StringRes(
                    R.string.dashboard_greeting_afternoon
                )

            in 17..20 ->
                UiText.StringRes(
                    R.string.dashboard_greeting_evening
                )

            else ->
                UiText.StringRes(
                    R.string.dashboard_greeting_night
                )
        }
    }
}
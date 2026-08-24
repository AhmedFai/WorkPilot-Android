package com.faizan.workpilot.features.dashboard.employee.domain.usecase

import com.faizan.workpilot.features.dashboard.employee.domain.model.EmployeeDashboard
import com.faizan.workpilot.features.dashboard.employee.domain.repository.DashboardRepository
import jakarta.inject.Inject

class GetEmployeeDashboardUseCase @Inject constructor(
    private val repository: DashboardRepository
) {

    suspend operator fun invoke(): EmployeeDashboard {
        return repository.getEmployeeDashboard()
    }
}
package com.faizan.workpilot.features.dashboard.superAdmin.domain.usecase

import com.faizan.workpilot.features.dashboard.superAdmin.domain.model.SuperAdminDashboard
import com.faizan.workpilot.features.dashboard.superAdmin.domain.repository.SuperAdminDashboardRepository
import javax.inject.Inject

class SuperAdminDashboardUseCase @Inject constructor(
    private val repository: SuperAdminDashboardRepository
) {
    suspend operator fun invoke(): SuperAdminDashboard {
        return repository.getDashboard()
    }
}
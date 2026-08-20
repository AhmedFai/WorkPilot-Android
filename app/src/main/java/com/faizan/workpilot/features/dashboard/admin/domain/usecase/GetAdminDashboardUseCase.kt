package com.faizan.workpilot.features.dashboard.admin.domain.usecase

import com.faizan.workpilot.features.dashboard.admin.domain.model.AdminDashboard
import com.faizan.workpilot.features.dashboard.admin.domain.repository.DashboardRepository
import jakarta.inject.Inject

class GetAdminDashboardUseCase @Inject constructor(
    private val repository: DashboardRepository
) {

    suspend operator fun invoke(): AdminDashboard {
        return repository.getAdminDashboard()
    }
}
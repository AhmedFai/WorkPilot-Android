package com.faizan.workpilot.features.dashboard.domain.usecase

import com.faizan.workpilot.features.dashboard.domain.model.AdminDashboard
import com.faizan.workpilot.features.dashboard.domain.repository.DashboardRepository
import jakarta.inject.Inject

class GetAdminDashboardUseCase @Inject constructor(
    private val repository: DashboardRepository
) {

    suspend operator fun invoke(): AdminDashboard {
        return repository.getAdminDashboard()
    }
}
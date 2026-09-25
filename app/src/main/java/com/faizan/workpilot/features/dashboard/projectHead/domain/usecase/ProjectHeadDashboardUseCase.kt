package com.faizan.workpilot.features.dashboard.projectHead.domain.usecase

import com.faizan.workpilot.features.dashboard.projectHead.domain.model.ProjectHeadDashboard
import com.faizan.workpilot.features.dashboard.projectHead.domain.repository.ProjectHeadDashboardRepository
import javax.inject.Inject

class ProjectHeadDashboardUseCase @Inject constructor(
    private val repository: ProjectHeadDashboardRepository
) {

    suspend operator fun invoke(): ProjectHeadDashboard {
        return repository.getDashboard()
    }
}
package com.faizan.workpilot.features.dashboard.presentation.mapper

import com.faizan.workpilot.features.dashboard.domain.model.AdminDashboard
import com.faizan.workpilot.features.dashboard.presentation.model.CompanyUiModel
import com.faizan.workpilot.features.dashboard.presentation.model.DashboardUiState
import com.faizan.workpilot.features.dashboard.presentation.model.RecentProjectUiModel

fun AdminDashboard.toUiState(
    currentState: DashboardUiState
): DashboardUiState {

    return currentState.copy(
        company = CompanyUiModel(
            id = company.id,
            name = company.name,
            email = company.email,
            logoUrl = company.logoUrl
        ),
        employeeCount = employeeCount,
        projectCount = projectCount,
        taskCount = taskCount,
        recentProjects = recentProjects.map { project ->
            RecentProjectUiModel(
                id = project.id,
                name = project.name,
                status = project.status,
                statusLabel = project.status
                    .replace("_", " ")
                    .lowercase()
                    .replaceFirstChar {
                        it.uppercase()
                    }
            )
        }
    )
}
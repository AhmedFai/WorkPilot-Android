package com.faizan.workpilot.features.dashboard.admin.presentation.mapper

import com.faizan.workpilot.features.dashboard.admin.domain.model.AdminDashboard
import com.faizan.workpilot.features.dashboard.admin.presentation.model.CompanyUiModel
import com.faizan.workpilot.features.dashboard.admin.presentation.model.DashboardUiState
import com.faizan.workpilot.features.dashboard.admin.presentation.model.RecentProjectUiModel

fun AdminDashboard.toUiState(
    currentState: com.faizan.workpilot.features.dashboard.admin.presentation.model.DashboardUiState
): com.faizan.workpilot.features.dashboard.admin.presentation.model.DashboardUiState {

    return currentState.copy(
        company = _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.model.CompanyUiModel(
            id = company.id,
            name = company.name,
            email = company.email,
            logoUrl = company.logoUrl
        ),
        employeeCount = employeeCount,
        projectCount = projectCount,
        taskCount = taskCount,
        recentProjects = recentProjects.map { project ->
            _root_ide_package_.com.faizan.workpilot.features.dashboard.admin.presentation.model.RecentProjectUiModel(
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
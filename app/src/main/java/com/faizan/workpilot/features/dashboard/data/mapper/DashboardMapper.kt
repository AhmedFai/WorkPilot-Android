package com.faizan.workpilot.features.dashboard.data.mapper

import com.faizan.workpilot.features.dashboard.data.model.AdminDashboardDto
import com.faizan.workpilot.features.dashboard.domain.model.AdminDashboard
import com.faizan.workpilot.features.dashboard.domain.model.Company
import com.faizan.workpilot.features.dashboard.domain.model.RecentProject

fun AdminDashboardDto.toDomain(): AdminDashboard {

    return AdminDashboard(
        company = Company(
            id = company.id,
            name = company.name,
            email = company.email,
            logoUrl = company.logoUrl
        ),
        employeeCount = employeeCount,
        projectCount = projectCount,
        taskCount = taskCount,
        recentProjects = recentProjects.map { project ->

            RecentProject(
                id = project.id,
                name = project.name,
                status = project.status,
                logoUrl = project.logoUrl
            )
        }
    )
}
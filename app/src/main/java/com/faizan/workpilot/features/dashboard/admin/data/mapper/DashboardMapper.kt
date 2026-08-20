package com.faizan.workpilot.features.dashboard.admin.data.mapper

import com.faizan.workpilot.features.dashboard.admin.data.model.AdminDashboardDto
import com.faizan.workpilot.features.dashboard.admin.domain.model.AdminDashboard
import com.faizan.workpilot.features.dashboard.admin.domain.model.Company
import com.faizan.workpilot.features.dashboard.admin.domain.model.RecentProject

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
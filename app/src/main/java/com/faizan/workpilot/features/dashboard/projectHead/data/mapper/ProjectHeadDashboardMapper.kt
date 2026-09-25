package com.faizan.workpilot.features.dashboard.projectHead.data.mapper

import com.faizan.workpilot.features.dashboard.projectHead.data.model.ProjectHeadDashboardDto
import com.faizan.workpilot.features.dashboard.projectHead.data.model.ProjectHeadProjectDto
import com.faizan.workpilot.features.dashboard.projectHead.domain.model.ProjectHeadDashboard
import com.faizan.workpilot.features.dashboard.projectHead.domain.model.ProjectHeadProject

fun ProjectHeadDashboardDto.toDomain(): ProjectHeadDashboard {

    return ProjectHeadDashboard(
        currentProjectCount = currentProjectCount,
        taskCount = taskCount,
        overdueTaskCount = overdueTaskCount,
        projects = projects.map {
            it.toDomain()
        }
    )
}

fun ProjectHeadProjectDto.toDomain(): ProjectHeadProject {

    return ProjectHeadProject(
        id = id,
        name = name,
        progress = progress
    )
}
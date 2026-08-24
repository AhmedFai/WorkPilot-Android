package com.faizan.workpilot.features.dashboard.employee.data.mapper

import com.faizan.workpilot.features.dashboard.employee.data.model.EmployeeDashboardDto
import com.faizan.workpilot.features.dashboard.employee.data.model.EmployeeTodayTaskDto
import com.faizan.workpilot.features.dashboard.employee.data.model.ProjectSummaryDto
import com.faizan.workpilot.features.dashboard.employee.domain.model.EmployeeDashboard
import com.faizan.workpilot.features.dashboard.employee.domain.model.EmployeeTodayTask
import com.faizan.workpilot.features.dashboard.employee.domain.model.ProjectSummary

fun EmployeeDashboardDto.toDomain(): EmployeeDashboard {
    return EmployeeDashboard(
        myTaskCount = myTaskCount,
        completedTaskCount = completedTaskCount,
        pendingTaskCount = pendingTaskCount,
        todayTasks = todayTasks.map {
            it.toDomain()
        }
    )
}

fun EmployeeTodayTaskDto.toDomain(): EmployeeTodayTask {
    return EmployeeTodayTask(
        id = id,
        title = title,
        project = project.toDomain(),
        priority = priority,
        status = status,
        deadline = deadline
    )
}

fun ProjectSummaryDto.toDomain(): ProjectSummary {
    return ProjectSummary(
        id = id,
        name = name
    )
}
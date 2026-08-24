package com.faizan.workpilot.features.dashboard.employee.data.model

data class EmployeeDashboardDto(
    val myTaskCount: Long,
    val completedTaskCount: Long,
    val pendingTaskCount: Long,
    val todayTasks: List<EmployeeTodayTaskDto>
)

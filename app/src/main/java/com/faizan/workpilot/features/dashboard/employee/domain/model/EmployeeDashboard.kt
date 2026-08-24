package com.faizan.workpilot.features.dashboard.employee.domain.model

data class EmployeeDashboard(
    val myTaskCount: Long,
    val completedTaskCount: Long,
    val pendingTaskCount: Long,
    val todayTasks: List<EmployeeTodayTask>
)

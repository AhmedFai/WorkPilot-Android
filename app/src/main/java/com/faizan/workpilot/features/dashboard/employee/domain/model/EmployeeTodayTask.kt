package com.faizan.workpilot.features.dashboard.employee.domain.model

import com.faizan.workpilot.core.common.domain.model.Priority
import com.faizan.workpilot.core.common.domain.model.Status

data class EmployeeTodayTask(
    val id: Long,
    val title: String,
    val project: ProjectSummary,
    val priority: Priority,
    val status: Status,
    val deadline: String
)

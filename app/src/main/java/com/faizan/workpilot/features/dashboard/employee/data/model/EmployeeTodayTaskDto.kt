package com.faizan.workpilot.features.dashboard.employee.data.model

import com.faizan.workpilot.core.common.domain.model.Priority
import com.faizan.workpilot.core.common.domain.model.Status

data class EmployeeTodayTaskDto(
    val id: Long,
    val title: String,
    val project: ProjectSummaryDto,
    val priority: Priority,
    val status: Status,
    val deadline: String
)

package com.faizan.workpilot.features.companyManagement.data.mapper

import com.faizan.workpilot.features.companyManagement.data.model.CompanyActivityPreviewDto
import com.faizan.workpilot.features.companyManagement.data.model.CompanyAdminPreviewDto
import com.faizan.workpilot.features.companyManagement.data.model.CompanyOverviewCompanyDto
import com.faizan.workpilot.features.companyManagement.data.model.CompanyOverviewResponseDto
import com.faizan.workpilot.features.companyManagement.data.model.CompanyTaskSummaryDto
import com.faizan.workpilot.features.companyManagement.domain.model.CompanyActivityPreview
import com.faizan.workpilot.features.companyManagement.domain.model.CompanyAdminPreview
import com.faizan.workpilot.features.companyManagement.domain.model.CompanyDashboard
import com.faizan.workpilot.features.companyManagement.domain.model.CompanyOverviewCompany
import com.faizan.workpilot.features.companyManagement.domain.model.CompanyTaskSummary

fun CompanyOverviewResponseDto.toDomain(): CompanyDashboard {

    return CompanyDashboard(
        company = data.company.toDomain(),
        totalUsers = data.totalUsers,
        activeProjects = data.activeProjects,
        totalTasks = data.totalTasks,
        taskSummary = data.taskSummary.toDomain(),
        recentActivities = data.recentActivities.map {
            it.toDomain()
        },
        adminPreview = data.adminPreview.map {
            it.toDomain()
        }
    )
}

private fun CompanyOverviewCompanyDto.toDomain(): CompanyOverviewCompany {

    return CompanyOverviewCompany(
        id = id,
        name = name,
        active = active
    )
}

private fun CompanyTaskSummaryDto.toDomain(): CompanyTaskSummary {

    return CompanyTaskSummary(
        pending = pending,
        inProgress = inProgress,
        completed = completed,
        overdue = overdue
    )
}

private fun CompanyActivityPreviewDto.toDomain(): CompanyActivityPreview {

    return CompanyActivityPreview(
        id = id,
        type = type,
        message = message,
        description = description,
        performedBy = performedBy,
        createdAt = createdAt
    )
}

private fun CompanyAdminPreviewDto.toDomain(): CompanyAdminPreview {

    return CompanyAdminPreview(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        active = active
    )
}
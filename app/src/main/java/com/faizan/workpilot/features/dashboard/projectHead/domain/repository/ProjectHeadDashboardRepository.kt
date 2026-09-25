package com.faizan.workpilot.features.dashboard.projectHead.domain.repository

import com.faizan.workpilot.features.dashboard.projectHead.domain.model.ProjectHeadDashboard

interface ProjectHeadDashboardRepository {

    suspend fun getDashboard(): ProjectHeadDashboard
}
package com.faizan.workpilot.features.dashboard.projectHead.data.repository

import com.faizan.workpilot.features.dashboard.projectHead.data.api.ProjectHeadDashboardApi
import com.faizan.workpilot.features.dashboard.projectHead.data.mapper.toDomain
import com.faizan.workpilot.features.dashboard.projectHead.domain.model.ProjectHeadDashboard
import com.faizan.workpilot.features.dashboard.projectHead.domain.repository.ProjectHeadDashboardRepository
import javax.inject.Inject

class ProjectHeadDashboardRepositoryImpl @Inject constructor(
    private val api: ProjectHeadDashboardApi
) : ProjectHeadDashboardRepository {

    override suspend fun getDashboard(): ProjectHeadDashboard {

        return api
            .getDashboard()
            .toDomain()
    }
}
package com.faizan.workpilot.features.companyManagement.presentation.model.dashboard

import com.faizan.workpilot.core.common.ui.text.UiText

sealed interface CompanyDashboardUiEvent {

    data class ShowError(
        val message: UiText
    ) : CompanyDashboardUiEvent
}
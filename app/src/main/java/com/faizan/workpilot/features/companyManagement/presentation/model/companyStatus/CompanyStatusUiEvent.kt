package com.faizan.workpilot.features.companyManagement.presentation.model.companyStatus

import com.faizan.workpilot.core.common.ui.text.UiText

sealed interface CompanyStatusUiEvent {
    data class ShowError(
        val message: UiText
    ) : CompanyStatusUiEvent
    data object StatusUpdated : CompanyStatusUiEvent
}
package com.faizan.workpilot.features.companyManagement.presentation.model.admin

import com.faizan.workpilot.core.common.ui.text.UiText

sealed interface EditCompanyAdminUiEvent {

    data class ShowError(
        val message: UiText
    ) : EditCompanyAdminUiEvent

    data class AdminUpdated(
        val message: String
    ) : EditCompanyAdminUiEvent
}
package com.faizan.workpilot.features.companyManagement.presentation.model.admin

import com.faizan.workpilot.core.common.ui.text.UiText

sealed interface CompanyAdminDetailsUiEvent {

    data class ShowError(
        val message: UiText
    ) : CompanyAdminDetailsUiEvent

    data object StatusUpdated : CompanyAdminDetailsUiEvent
}
package com.faizan.workpilot.features.company.presentation.model

import com.faizan.workpilot.core.common.ui.text.UiText

sealed interface CreateCompanyUiEvent {

    data class ShowSuccess(
        val message: UiText
    ) : CreateCompanyUiEvent

    data class ShowError(
        val message: UiText
    ) : CreateCompanyUiEvent

    data object CompanyCreated : CreateCompanyUiEvent
}
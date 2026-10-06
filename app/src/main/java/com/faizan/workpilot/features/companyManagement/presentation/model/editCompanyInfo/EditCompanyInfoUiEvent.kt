package com.faizan.workpilot.features.companyManagement.presentation.model.editCompanyInfo

import com.faizan.workpilot.core.common.ui.text.UiText

sealed interface EditCompanyInfoUiEvent {

    data class ShowError(
        val message: UiText
    ) : EditCompanyInfoUiEvent

    data object UpdateSuccess : EditCompanyInfoUiEvent
}
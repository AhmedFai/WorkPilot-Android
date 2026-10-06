package com.faizan.workpilot.features.companyManagement.presentation.model.companyInfo

import com.faizan.workpilot.core.common.ui.text.UiText

sealed interface CompanyInfoUiEvent {
    data class ShowError(
        val message: UiText
    ) : CompanyInfoUiEvent
}

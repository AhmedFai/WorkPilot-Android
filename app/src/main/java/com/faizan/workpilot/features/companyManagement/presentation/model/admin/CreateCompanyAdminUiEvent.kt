package com.faizan.workpilot.features.companyManagement.presentation.model.admin

import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdmin

sealed interface CreateCompanyAdminUiEvent {

    data class ShowError(
        val message: UiText
    ) : CreateCompanyAdminUiEvent

    data class AdminCreated(
        val admin: CompanyAdmin
    ) : CreateCompanyAdminUiEvent
}
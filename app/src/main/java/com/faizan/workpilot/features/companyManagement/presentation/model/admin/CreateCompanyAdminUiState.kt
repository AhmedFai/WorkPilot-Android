package com.faizan.workpilot.features.companyManagement.presentation.model.admin

import com.faizan.workpilot.core.common.ui.text.UiText

data class CreateCompanyAdminUiState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val password: String = "",

    val isLoading: Boolean = false,
    val error: UiText? = null
)
package com.faizan.workpilot.features.companyManagement.presentation.model.admin

import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminDetails

data class CompanyAdminDetailsUiState(
    val admin: CompanyAdminDetails? = null,
    val isLoading: Boolean = false,
    val isUpdatingStatus: Boolean = false,
    val error: UiText? = null
)
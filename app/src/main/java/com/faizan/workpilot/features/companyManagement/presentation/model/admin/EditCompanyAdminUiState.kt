package com.faizan.workpilot.features.companyManagement.presentation.model.admin

import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminDetails

data class EditCompanyAdminUiState(
    val admin: CompanyAdminDetails? = null,
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val designation: String? = null,
    val isLoading: Boolean = false,
    val isUpdating: Boolean = false,
    val error: UiText? = null
)
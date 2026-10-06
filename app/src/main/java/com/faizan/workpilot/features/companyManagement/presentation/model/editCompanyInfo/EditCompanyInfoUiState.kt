package com.faizan.workpilot.features.companyManagement.presentation.model.editCompanyInfo

import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo

data class EditCompanyInfoUiState(
    val isLoading: Boolean = false,
    val isSaving: Boolean = false,
    val companyInfo: CompanyInfo? = null,

    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val website: String = "",
    val addressLine1: String = "",
    val addressLine2: String = "",
    val city: String = "",
    val state: String = "",
    val postalCode: String = "",
    val country: String = "",

    val nameError: UiText? = null,
    val emailError: UiText? = null,

    val error: UiText? = null
)

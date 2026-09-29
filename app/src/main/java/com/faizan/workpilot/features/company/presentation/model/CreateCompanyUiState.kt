package com.faizan.workpilot.features.company.presentation.model

import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.features.company.domain.model.Company

data class CreateCompanyUiState(
    val isLoading: Boolean = false,
    val company: Company? = null,
    val nameError: UiText? = null,
    val emailError: UiText? = null,
    val generalError: UiText? = null
)
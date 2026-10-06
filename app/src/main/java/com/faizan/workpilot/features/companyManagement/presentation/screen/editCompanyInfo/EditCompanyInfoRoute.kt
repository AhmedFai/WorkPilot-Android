package com.faizan.workpilot.features.companyManagement.presentation.screen.editCompanyInfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faizan.workpilot.features.companyManagement.presentation.model.editCompanyInfo.EditCompanyInfoUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.viewmodel.editCompanyInfo.EditCompanyInfoViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EditCompanyInfoRoute(
    companyId: Long,
    onBackClick: () -> Unit,
    viewModel: EditCompanyInfoViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    LaunchedEffect(companyId) {
        viewModel.getCompanyInfo(companyId)
    }

    LaunchedEffect(Unit) {
        viewModel.events.collectLatest { event ->
            when (event) {
                is EditCompanyInfoUiEvent.UpdateSuccess -> {
                    onBackClick()
                }

                is EditCompanyInfoUiEvent.ShowError -> {
                    // Error handling will be added here.
                }
            }
        }
    }

    EditCompanyInfoScreen(
        uiState = uiState,
        onBackClick = onBackClick,
        onSaveClick = {
            viewModel.updateCompany(companyId)
        },
        onCancelClick = onBackClick,
        onNameChange = viewModel::onNameChange,
        onEmailChange = viewModel::onEmailChange,
        onPhoneChange = viewModel::onPhoneChange,
        onWebsiteChange = viewModel::onWebsiteChange,
        onAddressLine1Change = viewModel::onAddressLine1Change,
        onAddressLine2Change = viewModel::onAddressLine2Change,
        onCityChange = viewModel::onCityChange,
        onStateChange = viewModel::onStateChange,
        onPostalCodeChange = viewModel::onPostalCodeChange,
        onCountryChange = viewModel::onCountryChange
    )
}
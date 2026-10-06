package com.faizan.workpilot.features.companyManagement.presentation.screen.companyInfo

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.faizan.workpilot.features.companyManagement.presentation.model.companyInfo.CompanyInfoUiEvent
import com.faizan.workpilot.features.companyManagement.presentation.viewmodel.companyInfo.CompanyInfoViewModel

@Composable
fun CompanyInfoRoute(
    companyId: Long,
    onBackClick: () -> Unit,
    onEditInformationClick: () -> Unit,
    viewModel: CompanyInfoViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val uiState by viewModel
        .uiState
        .collectAsStateWithLifecycle()

    LaunchedEffect(companyId) {
        viewModel.getCompanyInfo(
            companyId = companyId
        )
    }

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is CompanyInfoUiEvent.ShowError -> {
                    Toast.makeText(
                        context,
                        event.message.asString(context),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    CompanyInfoScreen(
        uiState = uiState,
        onRetry = {
            viewModel.retry(
                companyId = companyId
            )
        },
        onBackClick = onBackClick,
        onEditInformationClick = onEditInformationClick
    )
}
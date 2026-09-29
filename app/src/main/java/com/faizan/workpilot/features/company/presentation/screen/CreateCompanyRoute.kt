package com.faizan.workpilot.features.company.presentation.screen

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.faizan.workpilot.core.common.ui.text.asString
import com.faizan.workpilot.features.company.presentation.model.CreateCompanyUiEvent
import com.faizan.workpilot.features.company.presentation.viewmodel.CreateCompanyViewModel

@Composable
fun CreateCompanyRoute(
    onBackClick: () -> Unit,
    onCompanyCreated: () -> Unit,
    viewModel: CreateCompanyViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { event ->

            when (event) {

                is CreateCompanyUiEvent.ShowSuccess -> {
                    Toast.makeText(
                        context,
                        event.message.asString(context),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is CreateCompanyUiEvent.ShowError -> {
                    Toast.makeText(
                        context,
                        event.message.asString(context),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                CreateCompanyUiEvent.CompanyCreated -> {
                    onCompanyCreated()
                }
            }
        }
    }

    CreateCompanyScreen(
        onBackClick = onBackClick,
        isLoading = uiState.isLoading,
        nameError = uiState.nameError,
        emailError = uiState.emailError,
        onNameChanged = viewModel::onNameChanged,
        onEmailChanged = viewModel::onEmailChanged,
        onCreateCompany = { name, email, phone, website, addressLine1,
                            addressLine2, city, state, postalCode, country ->

            viewModel.createCompany(
                name = name,
                email = email,
                phone = phone,
                website = website,
                addressLine1 = addressLine1,
                addressLine2 = addressLine2,
                city = city,
                state = state,
                postalCode = postalCode,
                country = country
            )
        }
    )
}
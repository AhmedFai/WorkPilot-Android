package com.faizan.workpilot.features.dashboard.superAdmin.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.components.ErrorContent
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.dashboard.admin.presentation.screen.DashboardHeader
import com.faizan.workpilot.features.dashboard.superAdmin.presentation.model.SuperAdminDashboardUiState
import com.faizan.workpilot.features.dashboard.superAdmin.presentation.screen.shimmer.SuperAdminDashboardShimmer

@Composable
fun SuperAdminDashboardScreen(
    uiState: SuperAdminDashboardUiState,
    onCompanyClick: (Long) -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember {
        mutableStateOf("")
    }

    val filteredCompanies = remember(
        uiState.companies,
        searchQuery
    ) {
        if (searchQuery.isBlank()) {
            uiState.companies
        } else {
            uiState.companies.filter { company ->
                company.name.contains(
                    searchQuery,
                    ignoreCase = true
                )
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .windowInsetsPadding(
                WindowInsets.safeDrawing
            )
    ) {

        when {
            uiState.isLoading -> {
                SuperAdminDashboardShimmer(
                    modifier = Modifier.fillMaxSize()
                )
            }

            uiState.error != null -> {
                ErrorContent(
                    error = uiState.error,
                    onRetry = onRetry,
                    modifier = Modifier.fillMaxSize()
                )
            }

            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(
                        horizontal = MaterialTheme
                            .dimens
                            .screenPaddingHorizontal,
                        vertical = MaterialTheme
                            .dimens
                            .spaceM
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        MaterialTheme.dimens.spaceM
                    )
                ) {

                    item {
                        DashboardHeader(
                            greeting = uiState.greeting,
                            userName = uiState.userName,
                            onSearchClick = {
                                // TODO
                            },
                            onProfileClick = {
                                // TODO
                            },
                            onNotificationClick = {
                                // TODO
                            }
                        )
                    }

                    item {
                        Text(
                            text = stringResource(R.string.choose_a_company),
                            style = MaterialTheme.typography.headlineSmall
                        )
                    }

                    item {
                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = {
                                searchQuery = it
                            },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = stringResource(R.string.Search_companies)
                                )
                            },
                            placeholder = {
                                Text(
                                    text = stringResource(R.string.Search_companies)
                                )
                            }
                        )
                    }

                    items(
                        items = filteredCompanies,
                        key = { company ->
                            company.id
                        }
                    ) { company ->

                        SuperAdminCompanyCard(
                            company = company,
                            onClick = {
                                onCompanyClick(company.id)
                            }
                        )
                    }
                }
            }
        }
    }
}
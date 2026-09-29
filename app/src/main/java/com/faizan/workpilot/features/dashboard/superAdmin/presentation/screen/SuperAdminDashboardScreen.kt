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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
    onSearchClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onProfileClick: () -> Unit,
    onCreateCompanyClick: () -> Unit,
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
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(
                            Alignment.Center
                        )
                )
            }

            else -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
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

                    DashboardHeader(
                        greeting = uiState.greeting,
                        userName = uiState.userName,
                        onSearchClick = onSearchClick,
                        onProfileClick = onProfileClick,
                        onNotificationClick = onNotificationClick
                    )

                    Text(
                        text = stringResource(
                            R.string.choose_a_company
                        ),
                        style = MaterialTheme.typography.headlineSmall
                    )

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
                                contentDescription = stringResource(
                                    R.string.Search_companies
                                )
                            )
                        },
                        placeholder = {
                            Text(
                                text = stringResource(
                                    R.string.Search_companies
                                )
                            )
                        }
                    )

                    LazyColumn(
                        modifier = Modifier.weight(1f),
                        contentPadding = PaddingValues(
                            bottom = MaterialTheme.dimens.spaceS
                        ),
                        verticalArrangement = Arrangement.spacedBy(
                            MaterialTheme.dimens.spaceM
                        )
                    ) {
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

                    Button(
                        onClick = onCreateCompanyClick,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null
                        )

                        Text(
                            text = stringResource(R.string.create_company)
                        )
                    }
                }
            }
        }
    }
}
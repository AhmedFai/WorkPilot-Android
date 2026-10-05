package com.faizan.workpilot.features.companyManagement.presentation.screen.admins

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.presentation.model.admin.CompanyAdminsUiState
import com.faizan.workpilot.features.companyManagement.presentation.screen.admins.components.CompanyAdminListItem
import com.faizan.workpilot.features.companyManagement.presentation.screen.admins.components.CompanyAdminsManageSection
import com.faizan.workpilot.features.companyManagement.presentation.screen.admins.components.CompanyAdminsTopSection

@Composable
fun CompanyAdminsScreen(
    uiState: CompanyAdminsUiState,
    onAddAdminClick: () -> Unit,
    onAdminClick: (Long) -> Unit,
    onSearchQueryChange: (String) -> Unit,
    onLoadNextPage: () -> Unit
) {

    val dimens = MaterialTheme.dimens
    val listState = rememberLazyListState()

    LaunchedEffect(listState) {
        snapshotFlow {
            listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
        }.collect { lastVisibleIndex ->

            val totalItems = listState.layoutInfo.totalItemsCount

            if (
                lastVisibleIndex != null &&
                lastVisibleIndex >= totalItems - 3
            ) {
                onLoadNextPage()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {

        // Fixed section
        CompanyAdminsTopSection(
            totalAdmins = uiState.totalElements,
            searchQuery = uiState.searchQuery,
            onAddAdminClick = onAddAdminClick,
            onSearchQueryChange = onSearchQueryChange
        )

        // Only this section scrolls
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(
                start = dimens.screenPaddingHorizontal,
                top = dimens.spaceS,
                end = dimens.screenPaddingHorizontal,
                bottom = dimens.spaceL
            ),
            verticalArrangement = Arrangement.spacedBy(
                dimens.spaceS
            )
        ) {

            items(
                items = uiState.admins,
                key = { admin ->
                    admin.id
                }
            ) { admin ->

                CompanyAdminListItem(
                    admin = admin,
                    onClick = {
                        onAdminClick(admin.id)
                    }
                )
            }

            item {
                CompanyAdminsManageSection(
                    onAddAdminClick = onAddAdminClick
                )
            }

            if (uiState.isLoadingMore) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = dimens.spaceS),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(dimens.iconM),
                            strokeWidth = dimens.space2XS
                        )
                    }
                }
            }
        }
    }
}
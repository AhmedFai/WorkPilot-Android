package com.faizan.workpilot.features.companyManagement.presentation.screen.companyInfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.component.AppTopBar
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.presentation.model.companyInfo.CompanyInfoUiState
import com.faizan.workpilot.features.companyManagement.presentation.screen.companyInfo.components.CompanyInfoDetailsCard
import com.faizan.workpilot.features.companyManagement.presentation.screen.companyInfo.components.CompanyInfoSummaryCard

@Composable
fun CompanyInfoScreen(
    uiState: CompanyInfoUiState,
    onRetry: () -> Unit,
    onBackClick: () -> Unit,
    onEditInformationClick: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    when {
        uiState.isLoading -> {
            // Shimmer will be added after the basic layout is verified.
        }

        uiState.companyInfo != null -> {
            val company = uiState.companyInfo

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
            ) {

                AppTopBar(
                    title = stringResource(R.string.company_settings_company_information),
                    onBackClick = onBackClick
                )

                CompanyInfoSummaryCard(
                    company = company
                )

                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            horizontal = dimens.screenPaddingHorizontal
                        ),
                    contentPadding = PaddingValues(
                        top = dimens.spaceM,
                        bottom = dimens.spaceM
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        dimens.spaceM
                    )
                ) {
                    item {
                        CompanyInfoDetailsCard(
                            company = company
                        )
                    }
                }

                Button(
                    onClick = onEditInformationClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = dimens.screenPaddingHorizontal,
                            vertical = dimens.spaceM
                        )
                ) {
                    Text(
                        text = stringResource(
                            R.string.company_information_edit_title
                        )
                    )
                }
            }
        }

        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = dimens.screenPaddingHorizontal,
                        vertical = dimens.screenPaddingVertical
                    ),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(
                        R.string.company_dashboard_something_went_wrong
                    )
                )

                Button(
                    onClick = onRetry
                ) {
                    Text(
                        text = stringResource(
                            R.string.company_dashboard_retry
                        )
                    )
                }
            }
        }
    }
}

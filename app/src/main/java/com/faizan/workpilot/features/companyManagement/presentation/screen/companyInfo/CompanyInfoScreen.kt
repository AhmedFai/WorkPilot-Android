package com.faizan.workpilot.features.companyManagement.presentation.screen.companyInfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.component.AppTopBar
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.presentation.companyInfo.CompanyInfoUiState
import com.faizan.workpilot.features.companyManagement.presentation.screen.companyInfo.components.CompanyInfoDetailsCard
import com.faizan.workpilot.features.companyManagement.presentation.screen.companyInfo.components.CompanyInfoSummaryCard

@Composable
fun CompanyInfoScreen(
    uiState: CompanyInfoUiState,
    onRetry: () -> Unit,
    onBackClick: () -> Unit
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
                        .fillMaxSize()
                        .padding(
                            horizontal = dimens.screenPaddingHorizontal
                        ),
                    contentPadding = PaddingValues(
                        top = dimens.spaceM,
                        bottom = dimens.spaceL
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

 data class CompanyInfoIconStyle(
    val containerColor: Color,
    val iconColor: Color
)

 object CompanyInfoIconColors {

    val companyName = CompanyInfoIconStyle(
        containerColor = Color(0xFFE8DEFF),
        iconColor = Color(0xFF5B4AE8)
    )

    val email = CompanyInfoIconStyle(
        containerColor = Color(0xFFE0E7FF),
        iconColor = Color(0xFF4F46E5)
    )

    val phone = CompanyInfoIconStyle(
        containerColor = Color(0xFFDDF7E8),
        iconColor = Color(0xFF16A34A)
    )

    val website = CompanyInfoIconStyle(
        containerColor = Color(0xFFDDF5F7),
        iconColor = Color(0xFF0891B2)
    )

    val address = CompanyInfoIconStyle(
        containerColor = Color(0xFFFFE4DC),
        iconColor = Color(0xFFF05A3C)
    )

    val city = CompanyInfoIconStyle(
        containerColor = Color(0xFFE4E7FF),
        iconColor = Color(0xFF4F46E5)
    )

    val state = CompanyInfoIconStyle(
        containerColor = Color(0xFFE0ECFF),
        iconColor = Color(0xFF2563EB)
    )

    val postalCode = CompanyInfoIconStyle(
        containerColor = Color(0xFFFFEBD2),
        iconColor = Color(0xFFEA8A00)
    )

    val country = CompanyInfoIconStyle(
        containerColor = Color(0xFFE0F0FF),
        iconColor = Color(0xFF1677C8)
    )

    val createdAt = CompanyInfoIconStyle(
        containerColor = Color(0xFFE8EDF5),
        iconColor = Color(0xFF526174)
    )

    val updatedAt = CompanyInfoIconStyle(
        containerColor = Color(0xFFEDE5FF),
        iconColor = Color(0xFF7652C7)
    )
}
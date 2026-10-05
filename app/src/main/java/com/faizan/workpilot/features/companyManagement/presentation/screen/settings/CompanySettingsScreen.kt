package com.faizan.workpilot.features.companyManagement.presentation.screen.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.presentation.screen.settings.components.CompanySettingsDangerItem
import com.faizan.workpilot.features.companyManagement.presentation.screen.settings.components.CompanySettingsIcon
import com.faizan.workpilot.features.companyManagement.presentation.screen.settings.components.CompanySettingsItem
import com.faizan.workpilot.features.companyManagement.presentation.screen.settings.components.CompanySettingsSection

@Composable
fun CompanySettingsScreen(
    companyActive: Boolean,
    onCompanyInformationClick: () -> Unit,
    onCompanyStatusClick: () -> Unit,
    onAdminManagementClick: () -> Unit,
    onDeactivateCompanyClick: () -> Unit
) {
    val dimens = MaterialTheme.dimens

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        contentPadding = PaddingValues(
            start = dimens.screenPaddingHorizontal,
            top = dimens.spaceM,
            bottom = dimens.spaceL,
            end = dimens.screenPaddingHorizontal
        ),
        verticalArrangement = Arrangement.spacedBy(
            dimens.spaceL
        )
    ) {

        item {
            CompanySettingsSection(
                title = stringResource(R.string.company_settings_company)
            ) {
                CompanySettingsItem(
                    iconType = CompanySettingsIcon.COMPANY,
                    title = stringResource(
                        R.string.company_settings_company_information
                    ),
                    description = stringResource(
                        R.string.company_settings_company_information_description
                    ),
                    onClick = onCompanyInformationClick
                )
                HorizontalDivider(
                    modifier = Modifier.padding(
                        horizontal = dimens.spaceM
                    )
                )
                CompanySettingsItem(
                    iconType = CompanySettingsIcon.STATUS,
                    title = stringResource(
                        R.string.company_settings_company_status
                    ),
                    description = stringResource(
                        if (companyActive) {
                            R.string.company_settings_active
                        } else {
                            R.string.company_settings_inactive
                        }
                    ),
                    onClick = onCompanyStatusClick
                )
            }
        }

        item {
            CompanySettingsSection(
                title = stringResource(
                    R.string.company_settings_administration
                )
            ) {
                CompanySettingsItem(
                    iconType = CompanySettingsIcon.ADMINS,
                    title = stringResource(
                        R.string.company_settings_admin_management
                    ),
                    description = stringResource(
                        R.string.company_settings_admin_management_description
                    ),
                    onClick = onAdminManagementClick
                )
            }
        }

        item {
            CompanySettingsSection(
                title = stringResource(
                    R.string.company_settings_danger_zone
                )
            ) {
                CompanySettingsDangerItem(
                    onClick = onDeactivateCompanyClick
                )
            }
        }
    }
}
package com.faizan.workpilot.features.companyManagement.presentation.screen.editCompanyInfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.component.AppTopBar
import com.faizan.workpilot.core.common.ui.text.asString
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.presentation.model.editCompanyInfo.EditCompanyInfoUiState
import com.faizan.workpilot.features.companyManagement.presentation.screen.components.CompanyInfoIconColors
import com.faizan.workpilot.features.companyManagement.presentation.screen.editCompanyInfo.components.EditCompanyInfoField
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@Composable
fun EditCompanyInfoScreen(
    uiState: EditCompanyInfoUiState,
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit,
    onCancelClick: () -> Unit,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
    onWebsiteChange: (String) -> Unit,
    onAddressLine1Change: (String) -> Unit,
    onAddressLine2Change: (String) -> Unit,
    onCityChange: (String) -> Unit,
    onStateChange: (String) -> Unit,
    onPostalCodeChange: (String) -> Unit,
    onCountryChange: (String) -> Unit
) {
    val dimens = androidx.compose.material3.MaterialTheme.dimens

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppTopBar(
            title = stringResource(
                R.string.company_information_edit_title
            ),
            onBackClick = onBackClick,
            enabled = !uiState.isSaving
        )

        if (uiState.isLoading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimens.screenPaddingHorizontal),
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(
                    horizontal = dimens.screenPaddingHorizontal,
                    vertical = dimens.spaceM
                ),
                verticalArrangement = Arrangement.spacedBy(
                    dimens.spaceM
                )
            ) {
//                item {
//                    Text(
//                        text = stringResource(
//                            R.string.company_information_edit_title
//                        )
//                    )
//                }

                // Fields will come here.

                item {
                    EditCompanyInfoField(
                        icon = Icons.Default.Badge,
                        label = stringResource(
                            R.string.company_information_company_name
                        ),
                        value = uiState.name,
                        onValueChange = onNameChange,
                        iconStyle = CompanyInfoIconColors.companyName,
                        isError = uiState.nameError != null,
                        errorMessage = uiState.nameError?.asString()
                    )
                }

                item {
                    EditCompanyInfoField(
                        icon = Icons.Default.Email,
                        label = stringResource(
                            R.string.company_information_email
                        ),
                        value = uiState.email,
                        onValueChange = onEmailChange,
                        iconStyle = CompanyInfoIconColors.email,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        ),
                        isError = uiState.emailError != null,
                        errorMessage = uiState.emailError?.asString()
                    )
                }

                item {
                    EditCompanyInfoField(
                        icon = Icons.Default.Phone,
                        label = stringResource(
                            R.string.company_information_phone
                        ),
                        value = uiState.phone,
                        onValueChange = onPhoneChange,
                        iconStyle = CompanyInfoIconColors.phone,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone
                        )
                    )
                }

                item {
                    EditCompanyInfoField(
                        icon = Icons.Default.Language,
                        label = stringResource(
                            R.string.company_information_website
                        ),
                        value = uiState.website,
                        onValueChange = onWebsiteChange,
                        iconStyle = CompanyInfoIconColors.website,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Uri
                        )
                    )
                }

                item {
                    EditCompanyInfoField(
                        icon = Icons.Default.LocationOn,
                        label = stringResource(
                            R.string.company_information_address_line_1
                        ),
                        value = uiState.addressLine1,
                        onValueChange = onAddressLine1Change,
                        iconStyle = CompanyInfoIconColors.address
                    )
                }

                item {
                    EditCompanyInfoField(
                        icon = Icons.Default.LocationOn,
                        label = stringResource(
                            R.string.company_information_address_line_2
                        ),
                        value = uiState.addressLine2,
                        onValueChange = onAddressLine2Change,
                        iconStyle = CompanyInfoIconColors.address
                    )
                }

                item {
                    EditCompanyInfoField(
                        icon = Icons.Default.LocationCity,
                        label = stringResource(
                            R.string.company_information_city
                        ),
                        value = uiState.city,
                        onValueChange = onCityChange,
                        iconStyle = CompanyInfoIconColors.city
                    )
                }

                item {
                    EditCompanyInfoField(
                        icon = Icons.Default.Map,
                        label = stringResource(
                            R.string.company_information_state
                        ),
                        value = uiState.state,
                        onValueChange = onStateChange,
                        iconStyle = CompanyInfoIconColors.state
                    )
                }

                item {
                    EditCompanyInfoField(
                        icon = Icons.Default.LocationOn,
                        label = stringResource(
                            R.string.company_information_postal_code
                        ),
                        value = uiState.postalCode,
                        onValueChange = onPostalCodeChange,
                        iconStyle = CompanyInfoIconColors.postalCode,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        )
                    )
                }

                item {
                    EditCompanyInfoField(
                        icon = Icons.Default.Public,
                        label = stringResource(
                            R.string.company_information_country
                        ),
                        value = uiState.country,
                        onValueChange = onCountryChange,
                        iconStyle = CompanyInfoIconColors.country
                    )
                }

            }

            // Save / Cancel buttons will come here.

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = dimens.screenPaddingHorizontal,
                        vertical = dimens.spaceS
                    ),
                horizontalArrangement = Arrangement.spacedBy(
                    dimens.spaceS
                )
            ) {
                OutlinedButton(
                    onClick = onCancelClick,
                    enabled = !uiState.isSaving,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(
                            R.string.company_information_cancel
                        )
                    )
                }

                Button(
                    onClick = onSaveClick,
                    enabled = !uiState.isSaving,
                    modifier = Modifier.weight(1f)
                ) {
                    if (uiState.isSaving) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(MaterialTheme.dimens.iconS)
                                .align(Alignment.CenterVertically),
                            strokeWidth = MaterialTheme.dimens.space2XS / 2
                        )
                    } else {
                        Text(
                            text = stringResource(
                                R.string.company_information_save
                            )
                        )
                    }
                }
            }
        }
    }
}
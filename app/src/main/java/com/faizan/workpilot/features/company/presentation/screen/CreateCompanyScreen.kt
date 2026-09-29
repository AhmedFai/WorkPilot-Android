package com.faizan.workpilot.features.company.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.UiText
import com.faizan.workpilot.core.common.ui.text.asString
import com.faizan.workpilot.core.ui.components.AppTextField
import com.faizan.workpilot.core.common.ui.component.AppTopBar
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun CreateCompanyScreen(
    onBackClick: () -> Unit,
    onCreateCompany: (
        name: String,
        email: String,
        phone: String?,
        website: String?,
        addressLine1: String?,
        addressLine2: String?,
        city: String?,
        state: String?,
        postalCode: String?,
        country: String?
    ) -> Unit,
    onNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    isLoading: Boolean = false,
    nameError: UiText? = null,
    emailError: UiText? = null
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var website by remember { mutableStateOf("") }

    var addressLine1 by remember { mutableStateOf("") }
    var addressLine2 by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var postalCode by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        AppTopBar(
            title = stringResource(R.string.create_company),
            onBackClick = onBackClick,
            enabled = !isLoading
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(
                    horizontal = MaterialTheme.dimens.screenPaddingHorizontal,
                    vertical = MaterialTheme.dimens.screenPaddingVertical
                ),
            verticalArrangement = Arrangement.spacedBy(
                MaterialTheme.dimens.spaceM
            )
        ) {

            Text(
                text = stringResource(R.string.create_company_title),
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = stringResource(R.string.create_company_description),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(
                    MaterialTheme.dimens.spaceS
                )
            )

            Text(
                text = stringResource(R.string.company_basic_information),
                style = MaterialTheme.typography.titleMedium
            )

            AppTextField(
                value = name,
                onValueChange = {
                    name = it
                    onNameChanged(it)
                },
                label = stringResource(R.string.company_name),
                modifier = Modifier.fillMaxWidth(),
                isError = nameError != null,
                supportingText = nameError?.asString()
            )

            AppTextField(
                value = email,
                onValueChange = {
                    email = it
                    onEmailChanged(it)
                },
                label = stringResource(R.string.company_email),
                modifier = Modifier.fillMaxWidth(),
                isError = emailError != null,
                supportingText = emailError?.asString(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )

            AppTextField(
                value = phone,
                onValueChange = { phone = it },
                label = stringResource(R.string.company_phone),
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                )
            )

            AppTextField(
                value = website,
                onValueChange = { website = it },
                label = stringResource(R.string.company_website),
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Uri
                )
            )

            Spacer(
                modifier = Modifier.height(
                    MaterialTheme.dimens.spaceS
                )
            )

            Text(
                text = stringResource(R.string.company_address),
                style = MaterialTheme.typography.titleMedium
            )

            AppTextField(
                value = addressLine1,
                onValueChange = { addressLine1 = it },
                label = stringResource(R.string.company_address_line_1),
                modifier = Modifier.fillMaxWidth()
            )

            AppTextField(
                value = addressLine2,
                onValueChange = { addressLine2 = it },
                label = stringResource(R.string.company_address_line_2),
                modifier = Modifier.fillMaxWidth()
            )

            AppTextField(
                value = city,
                onValueChange = { city = it },
                label = stringResource(R.string.company_city),
                modifier = Modifier.fillMaxWidth()
            )

            AppTextField(
                value = state,
                onValueChange = { state = it },
                label = stringResource(R.string.company_state),
                modifier = Modifier.fillMaxWidth()
            )

            AppTextField(
                value = postalCode,
                onValueChange = { postalCode = it },
                label = stringResource(R.string.company_postal_code),
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )

            AppTextField(
                value = country,
                onValueChange = { country = it },
                label = stringResource(R.string.company_country),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(
                    MaterialTheme.dimens.spaceS
                )
            )

            Button(
                onClick = {
                    onCreateCompany(
                        name,
                        email,
                        phone.ifBlank { null },
                        website.ifBlank { null },
                        addressLine1.ifBlank { null },
                        addressLine2.ifBlank { null },
                        city.ifBlank { null },
                        state.ifBlank { null },
                        postalCode.ifBlank { null },
                        country.ifBlank { null }
                    )
                },
                enabled = !isLoading,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MaterialTheme.dimens.buttonHeight)
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(MaterialTheme.dimens.iconS)
                            .align(Alignment.CenterVertically),
                        strokeWidth = MaterialTheme.dimens.space2XS / 2
                    )
                } else {
                    Text(
                        text = stringResource(R.string.create_company)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(
                    MaterialTheme.dimens.spaceM
                )
            )
        }
    }
}
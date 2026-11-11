
package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun CompanyAdminForm(
    firstName: String,
    lastName: String,
    email: String,
    password: String,
    phoneNumber: String,
    isEditMode: Boolean,
    isLoading: Boolean,
    onFirstNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val dimens = MaterialTheme.dimens
    val colors = MaterialTheme.colorScheme

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(dimens.spaceS)
    ) {

        // First Name
        AdminFormField(
            icon = Icons.Default.Person,
            label = stringResource(R.string.admin_first_name_label),
            value = firstName,
            onValueChange = onFirstNameChange,
            iconBackgroundColor = colors.primaryContainer,
            iconTint = colors.onPrimaryContainer
        )

        // Last Name
        AdminFormField(
            icon = Icons.Default.Person,
            label = stringResource(R.string.admin_last_name_label),
            value = lastName,
            onValueChange = onLastNameChange,
            iconBackgroundColor = colors.secondaryContainer,
            iconTint = colors.onSecondaryContainer
        )

        // Email
        AdminFormField(
            icon = Icons.Default.Email,
            label = stringResource(R.string.admin_email_label),
            value = email,
            onValueChange = onEmailChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            enabled = !isEditMode,
            readOnly = isEditMode,
            trailingIcon = if (isEditMode) {
                {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                }
            } else {
                null
            },
            iconBackgroundColor = colors.secondaryContainer,
            iconTint = colors.onSecondaryContainer
        )

        // Phone Number
        AdminFormField(
            icon = Icons.Default.Phone,
            label = stringResource(R.string.admin_phone_number_label),
            value = phoneNumber,
            onValueChange = onPhoneNumberChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            ),
            iconBackgroundColor = colors.tertiaryContainer,
            iconTint = colors.onTertiaryContainer
        )

        // Password
        if (!isEditMode) {
            AdminPasswordField(
                value = password,
                onValueChange = onPasswordChange,
                passwordVisible = passwordVisible,
                onPasswordVisibilityChange = {
                    passwordVisible = !passwordVisible
                }
            )
        }
    }
}

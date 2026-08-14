package com.faizan.workpilot.features.login.presentation.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.faizan.workpilot.R
import com.faizan.workpilot.core.common.ui.text.asString
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.login.presentation.model.LoginUiEvent
import com.faizan.workpilot.features.login.presentation.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val dimens = MaterialTheme.dimens
    val context = LocalContext.current

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {

        viewModel.uiEvent.collect { event ->

            when (event) {

                is LoginUiEvent.ShowSuccess -> {
                    Toast.makeText(
                        context,
                        event.message.asString(context),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is LoginUiEvent.ShowError -> {
                    Toast.makeText(
                        context,
                        event.message.asString(context),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                LoginUiEvent.LoginSuccess -> {
                    onLoginSuccess()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = dimens.screenPaddingHorizontal,
                vertical = dimens.screenPaddingVertical
            ),
        horizontalAlignment = Alignment.Start
    ) {

        Spacer(
            modifier = Modifier.height(
                dimens.space3XL
            )
        )

        // --------------------------------------------------
        // Header
        // --------------------------------------------------

        Text(
            text = stringResource(
                R.string.login_welcome_back
            ),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Text(
            text = stringResource(
                R.string.login_subtitle
            ),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(
                top = dimens.space2XS
            )
        )

        Spacer(
            modifier = Modifier.height(
                dimens.space2XL
            )
        )

        // --------------------------------------------------
        // Email
        // --------------------------------------------------

        Text(
            text = stringResource(
                R.string.login_email_label
            ),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(
            modifier = Modifier.height(
                dimens.spaceXS
            )
        )

        OutlinedTextField(
            value = uiState.email,
            onValueChange = viewModel::onEmailChanged,
            enabled = !uiState.isLoading,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            isError = uiState.emailError != null,
            supportingText = {
                uiState.emailError?.let { error ->
                    Text(
                        text = error.asString()
                    )
                }
            },
            placeholder = {
                Text(
                    text = stringResource(
                        R.string.login_email_placeholder
                    )
                )
            },
            shape = RoundedCornerShape(
                dimens.radiusM
            )
        )

        Spacer(
            modifier = Modifier.height(
                dimens.spaceM
            )
        )

        // --------------------------------------------------
        // Password
        // --------------------------------------------------

        Text(
            text = stringResource(
                R.string.login_password_label
            ),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(
            modifier = Modifier.height(
                dimens.spaceXS
            )
        )

        OutlinedTextField(
            value = uiState.password,
            onValueChange = viewModel::onPasswordChanged,
            enabled = !uiState.isLoading,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            isError = uiState.passwordError != null,
            supportingText = {
                uiState.passwordError?.let { error ->
                    Text(
                        text = error.asString()
                    )
                }
            },
            placeholder = {
                Text(
                    text = stringResource(
                        R.string.login_password_placeholder
                    )
                )
            },
            visualTransformation = if (uiState.isPasswordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {

                IconButton(
                    onClick = viewModel::onPasswordVisibilityChanged
                ) {

                    Icon(
                        imageVector = if (uiState.isPasswordVisible) {
                            Icons.Default.VisibilityOff
                        } else {
                            Icons.Default.Visibility
                        },
                        contentDescription = stringResource(
                            if (uiState.isPasswordVisible) {
                                R.string.login_password_hide
                            } else {
                                R.string.login_password_show
                            }
                        )
                    )
                }
            },
            shape = RoundedCornerShape(
                dimens.radiusM
            )
        )

        // --------------------------------------------------
        // Forgot Password
        // --------------------------------------------------

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {

            TextButton(
                onClick = {
                    // TODO: Forgot password
                },
                enabled = !uiState.isLoading
            ) {

                Text(
                    text = stringResource(
                        R.string.login_forgot_password
                    ),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        // --------------------------------------------------
        // Login Button
        // --------------------------------------------------

        Button(
            onClick = viewModel::login,
            enabled = !uiState.isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.buttonHeight),
            shape = RoundedCornerShape(
                dimens.radiusM
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContainerColor = MaterialTheme.colorScheme.primary
                    .copy(alpha = 0.6f),
                disabledContentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            if (uiState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(
                        dimens.iconS
                    ),
                    color = MaterialTheme.colorScheme.onPrimary,
                    strokeWidth = 2.dp
                )
            } else {
                Text(
                    text = stringResource(
                        R.string.login_button
                    ),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }

        Spacer(
            modifier = Modifier.height(
                dimens.spaceXL
            )
        )

        // --------------------------------------------------
        // Divider
        // --------------------------------------------------

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.outlineVariant
            )

            Text(
                text = stringResource(
                    R.string.login_continue_with
                ),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(
                    horizontal = dimens.spaceM
                )
            )

            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.outlineVariant
            )
        }

        Spacer(
            modifier = Modifier.height(
                dimens.spaceM
            )
        )

        // --------------------------------------------------
        // Google
        // --------------------------------------------------

        OutlinedButton(
            onClick = {
                // TODO: Google login
            },
            modifier = Modifier
                .size(
                    width = 56.dp,
                    height = 48.dp
                )
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(
                dimens.radiusM
            )
        ) {

            Text(
                text = "G",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        // --------------------------------------------------
        // Contact Admin
        // --------------------------------------------------

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = dimens.spaceS
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = stringResource(
                    R.string.login_no_account
                ),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            TextButton(
                onClick = {
                    // TODO: Contact admin
                },
                enabled = !uiState.isLoading,
                contentPadding = ButtonDefaults.TextButtonContentPadding
            ) {

                Text(
                    text = stringResource(
                        R.string.login_contact_admin
                    ),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
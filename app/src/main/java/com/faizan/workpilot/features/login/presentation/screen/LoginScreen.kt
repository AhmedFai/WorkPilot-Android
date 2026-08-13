package com.faizan.workpilot.features.login.presentation.screen

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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun LoginScreen() {

    val dimens = MaterialTheme.dimens

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
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
            text = "Welcome Back",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Text(
            text = "Login to continue",
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
            text = "Email",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(
            modifier = Modifier.height(
                dimens.spaceXS
            )
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = {
                Text(
                    text = "john@example.com"
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
            text = "Password",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(
            modifier = Modifier.height(
                dimens.spaceXS
            )
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = if (passwordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {

                IconButton(
                    onClick = {
                        passwordVisible = !passwordVisible
                    }
                ) {

                    Icon(
                        imageVector = if (passwordVisible) {
                            Icons.Default.VisibilityOff
                        } else {
                            Icons.Default.Visibility
                        },
                        contentDescription = if (passwordVisible) {
                            "Hide password"
                        } else {
                            "Show password"
                        }
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
                }
            ) {

                Text(
                    text = "Forgot Password",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        // --------------------------------------------------
        // Login Button
        // --------------------------------------------------

        Button(
            onClick = {
                // TODO: Login
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.buttonHeight),
            shape = RoundedCornerShape(
                dimens.radiusM
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {

            Text(
                text = "Login",
                style = MaterialTheme.typography.labelLarge
            )
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
                text = "Or continue with",
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
                text = "Don't have an account? ",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            TextButton(
                onClick = {
                    // TODO: Contact admin
                },
                contentPadding = ButtonDefaults.TextButtonContentPadding
            ) {

                Text(
                    text = "Contact Admin",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import com.faizan.workpilot.core.ui.theme.dimens
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

@Composable
fun AdminFormField(
    icon: ImageVector,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    isError: Boolean = false,
    errorMessage: String? = null,
    enabled: Boolean = true,
    trailingIcon: (@Composable () -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    readOnly: Boolean = false,
    iconBackgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
    iconTint: Color = MaterialTheme.colorScheme.onPrimaryContainer
) {
    val dimens = MaterialTheme.dimens

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(dimens.avatarS),
                shape = RoundedCornerShape(dimens.radiusM),
                color = iconBackgroundColor
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = iconTint,
                        modifier = Modifier.size(dimens.iconM)
                    )
                }
            }

            Spacer(
                modifier = Modifier.width(dimens.spaceM)
            )

            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                label = {
                    Text(text = label)
                },
                modifier = Modifier.weight(1f),
                singleLine = true,
                enabled = enabled,
                isError = isError,
                keyboardOptions = keyboardOptions,
                trailingIcon = trailingIcon,
                supportingText = {
                    if (isError && errorMessage != null) {
                        Text(text = errorMessage)
                    }
                },
                visualTransformation = visualTransformation,
                readOnly = readOnly
            )
        }
    }
}

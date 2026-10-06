package com.faizan.workpilot.features.companyManagement.presentation.screen.editCompanyInfo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.vector.ImageVector
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.presentation.screen.components.CompanyInfoIconStyle

@Composable
fun EditCompanyInfoField(
    icon: ImageVector,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    iconStyle: CompanyInfoIconStyle,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    val dimens = MaterialTheme.dimens

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(dimens.iconL),
                shape = RoundedCornerShape(dimens.radiusS),
                color = iconStyle.containerColor
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconStyle.iconColor,
                    modifier = Modifier.padding(dimens.spaceXS)
                )
            }

            Spacer(
                modifier = Modifier.width(dimens.spaceS)
            )

            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                label = {
                    Text(text = label)
                },
                modifier = Modifier.weight(1f),
                singleLine = true,
                isError = isError,
                keyboardOptions = keyboardOptions,
                supportingText = {
                    if (isError && errorMessage != null) {
                        Text(text = errorMessage)
                    }
                }
            )
        }
    }
}
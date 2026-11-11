package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens


@Composable
fun CompanyAdminFormActions(
    isEditMode: Boolean,
    isLoading: Boolean,
    onSubmit: () -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    val dimens = MaterialTheme.dimens

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimens.spaceM)
    ) {
        Button(
            onClick = onSubmit,
            enabled = !isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.buttonHeight)
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(dimens.iconS),
                    strokeWidth = dimens.space2XS
                )
            } else {
                Text(
                    text = stringResource(
                        if (isEditMode) R.string.admin_update_action
                        else R.string.admin_create_action
                    )
                )
            }
        }

        OutlinedButton(
            onClick = onCancel,
            enabled = !isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.buttonHeight)
        ) {
            Text(stringResource(R.string.admin_cancel))
        }
    }
}
package com.faizan.workpilot.features.companyManagement.presentation.screen.admins.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Alignment
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun CompanyAdminsTopSection(
    totalAdmins: Long,
    searchQuery: String,
    onAddAdminClick: () -> Unit,
    onSearchQueryChange: (String) -> Unit
) {
    val dimens = MaterialTheme.dimens

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimens.screenPaddingHorizontal
            ),
        verticalArrangement = Arrangement.spacedBy(
            dimens.spaceS
        )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = stringResource(
                    R.string.company_admins_title,
                    totalAdmins
                ),
                style = MaterialTheme.typography.titleMedium
            )

            Box(
                modifier = Modifier
                    .size(dimens.spaceXL)
                    .clickable(onClick = onAddAdminClick),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(
                        R.string.company_admins_add_admin
                    )
                )
            }
        }

        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = stringResource(
                        R.string.company_admins_search_placeholder
                    )
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            shape = MaterialTheme.shapes.medium
        )
    }
}
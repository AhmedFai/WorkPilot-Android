package com.faizan.workpilot.features.dashboard.employee.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun EmployeeTodayTasksHeader(
    onSortClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = stringResource(
                R.string.employee_today_tasks
            ),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        IconButton(
            onClick = onSortClick
        ) {

            Icon(
                imageVector = Icons.Default.Sort,
                contentDescription = stringResource(
                    R.string.employee_sort_tasks
                ),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
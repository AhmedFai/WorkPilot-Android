package com.faizan.workpilot.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CloudOff
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.core.network.error.NetworkError
import com.faizan.workpilot.core.network.error.NetworkErrorType
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun ErrorContent(
    error: NetworkError,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {

    val icon = when (error.type) {

        NetworkErrorType.NO_CONNECTION ->
            Icons.Rounded.CloudOff

        NetworkErrorType.UNAUTHORIZED,
        NetworkErrorType.FORBIDDEN ->
            Icons.Rounded.Lock

        else ->
            Icons.Rounded.ErrorOutline
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal =
                    MaterialTheme.dimens.screenPaddingHorizontal
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            MaterialTheme.dimens.spaceM
        )
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.error,
            modifier = Modifier.size(
                MaterialTheme.dimens.iconXL
            )
        )

        Text(
            text = error.message.asString(
                androidx.compose.ui.platform.LocalContext.current
            ),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        when (error.type) {

            NetworkErrorType.UNAUTHORIZED -> {
                // Login/session handling later
            }

            else -> {
                Button(
                    onClick = onRetry
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Refresh,
                        contentDescription = null
                    )

                    Text(
                        text = stringResource(R.string.common_retry),
                        modifier = Modifier.padding(
                            start = MaterialTheme.dimens.spaceXS
                        )
                    )
                }
            }
        }
    }
}
package com.faizan.workpilot.features.onboarding.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun OnboardingBottomActions(
    currentPage: Int,
    pageCount: Int,
    onBack: () -> Unit,
    onNext: () -> Unit,
    onSkip: () -> Unit,
    onGetStarted: () -> Unit,
    modifier: Modifier = Modifier
) {
    val dimens = MaterialTheme.dimens

    val isFirstPage = currentPage == 0
    val isLastPage = currentPage == pageCount - 1

    Row(
        modifier = modifier
            .fillMaxWidth().padding(
                start = dimens.screenPaddingHorizontal,
                end = dimens.screenPaddingHorizontal
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Left action
        if (isFirstPage) {

            TextButton(
                onClick = onSkip
            ) {
                Text(
                    text = stringResource(
                        R.string.onboarding_skip
                    ),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }

        } else {

            IconButton(
                onClick = onBack,
                modifier = Modifier
                    .size(dimens.buttonHeight)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(
                        R.string.onboarding_previous_page
                    ),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        // Right action
        if (isLastPage) {

            Button(
                onClick = onGetStarted,
                shape = MaterialTheme.shapes.extraLarge
            ) {
                Text(
                    text = stringResource(
                        R.string.onboarding_lets_go
                    ),
                    style = MaterialTheme.typography.labelLarge
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null
                )
            }

        } else {

            IconButton(
                onClick = onNext,
                modifier = Modifier
                    .size(dimens.buttonHeight)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = stringResource(
                        R.string.onboarding_next_page
                    ),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}
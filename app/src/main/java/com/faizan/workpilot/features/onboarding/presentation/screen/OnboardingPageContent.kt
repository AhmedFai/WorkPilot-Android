package com.faizan.workpilot.features.onboarding.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.onboarding.presentation.model.OnboardingPage

@Composable
fun OnboardingPageContent(
    page: OnboardingPage,
    modifier: Modifier = Modifier
) {
    val dimens = MaterialTheme.dimens

    Column(
        modifier = modifier.fillMaxSize()
            .padding(
                start = dimens.screenPaddingHorizontal,
                end = dimens.screenPaddingHorizontal
            ),
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = stringResource(page.titleRes),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Text(
            text = stringResource(page.descriptionRes),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(
                top = dimens.spaceXS
            )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(
                    top = dimens.spaceL,
                    bottom = dimens.spaceM
                ),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(page.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
        }
    }
}
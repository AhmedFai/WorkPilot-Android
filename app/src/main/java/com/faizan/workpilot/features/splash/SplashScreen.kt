package com.faizan.workpilot.features.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashFinished: (Boolean) -> Unit,
    viewModel: SplashViewModel = hiltViewModel()
) {

    var showContent by remember {
        mutableStateOf(false)
    }

    val dimens = MaterialTheme.dimens

    val isOnboardingCompleted by viewModel
        .isOnboardingCompleted
        .collectAsState()

    LaunchedEffect(Unit) {
        showContent = true
    }

    LaunchedEffect(isOnboardingCompleted) {

        if (isOnboardingCompleted != null) {

            delay(1200)

            onSplashFinished(
                isOnboardingCompleted
                    ?: false
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedVisibility(
            visible = showContent,
            modifier = Modifier.weight(1f),
            enter = fadeIn() + slideInVertically(
                initialOffsetY = { -20 }
            )
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painterResource(
                        id = R.drawable.ic_workpilot_logo
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(
                        width = dimens.logoWidth,
                        height = dimens.logoHeight
                    ),
                    contentScale = ContentScale.Fit
                )

                Text(
                    text = stringResource(
                        R.string.app_name
                    ),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Text(
                    text = stringResource(
                        R.string.splash_tagline
                    ),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(
                        top = dimens.spaceM
                    )
                )
            }
        }

        Image(
            painter = painterResource(
                id = R.drawable.splash_illustration
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Fit,
            alignment = Alignment.BottomCenter
        )
    }
}
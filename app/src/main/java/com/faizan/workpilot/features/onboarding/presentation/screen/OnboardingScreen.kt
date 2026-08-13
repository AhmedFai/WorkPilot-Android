package com.faizan.workpilot.features.onboarding.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.onboarding.data.onboardingPages
import com.faizan.workpilot.features.onboarding.presentation.viewmodel.OnboardingViewModel
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    onFinished: () -> Unit,
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    val dimens = MaterialTheme.dimens
    val scope = rememberCoroutineScope()

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = {
            onboardingPages.size
        }
    )

    LaunchedEffect(Unit) {
        viewModel.onboardingCompleted.collect {
            onFinished()
        }
    }

    val currentPage = pagerState.currentPage
    val isLastPage = currentPage == onboardingPages.lastIndex

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = WindowInsets.statusBars
                    .asPaddingValues()
                    .calculateTopPadding(),
                bottom = dimens.screenPaddingVertical
            )
    ) {

        // --------------------------------------------------
        // Top action
        // --------------------------------------------------

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextButton(
                onClick = {
                    if (isLastPage) {
                        viewModel.completeOnboarding()
                    } else {
                        viewModel.completeOnboarding()
                    }
                }
            ) {
                Text(
                    text = stringResource(
                        if (isLastPage) {
                            R.string.onboarding_get_started
                        } else {
                            R.string.onboarding_skip
                        }
                    ),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        // --------------------------------------------------
        // Pager
        // --------------------------------------------------

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) { page ->

            OnboardingPageContent(
                page = onboardingPages[page]
            )
        }

        // --------------------------------------------------
        // Indicators
        // --------------------------------------------------

        OnboardingIndicators(
            pageCount = onboardingPages.size,
            currentPage = currentPage,
            onPageSelected = { page ->
                scope.launch {
                    pagerState.animateScrollToPage(page)
                }
            },
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )

        // --------------------------------------------------
        // Bottom actions
        // --------------------------------------------------

        OnboardingBottomActions(
            currentPage = currentPage,
            pageCount = onboardingPages.size,
            onBack = {
                scope.launch {
                    pagerState.animateScrollToPage(
                        currentPage - 1
                    )
                }
            },
            onNext = {
                scope.launch {
                    pagerState.animateScrollToPage(
                        currentPage + 1
                    )
                }
            },
            onSkip = {
                viewModel.completeOnboarding()
            },
            onGetStarted = {
                viewModel.completeOnboarding()
            },
            modifier = Modifier.padding(
                top = dimens.spaceM
            )
        )
    }
}


package com.faizan.workpilot.features.onboarding.data

import com.faizan.workpilot.R
import com.faizan.workpilot.features.onboarding.presentation.model.OnboardingPage

val onboardingPages = listOf(
    OnboardingPage(
        titleRes = R.string.onboarding_page_1_title,
        descriptionRes = R.string.onboarding_page_1_description,
        imageRes = R.drawable.onboarding_workplace
    ),
    OnboardingPage(
        titleRes = R.string.onboarding_page_2_title,
        descriptionRes = R.string.onboarding_page_2_description,
        imageRes = R.drawable.onboarding_attendance
    ),
    OnboardingPage(
        titleRes = R.string.onboarding_page_3_title,
        descriptionRes = R.string.onboarding_page_3_description,
        imageRes = R.drawable.onboarding_collaboration
    )
)
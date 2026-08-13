package com.faizan.workpilot.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.faizan.workpilot.features.login.presentation.screen.LoginScreen
import com.faizan.workpilot.features.onboarding.presentation.screen.OnboardingScreen
import com.faizan.workpilot.features.splash.SplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.SPLASH
    ) {

        composable(AppRoutes.SPLASH) {

            SplashScreen(
                onSplashFinished = { isOnboardingCompleted ->

                    val destination =
                        if (isOnboardingCompleted) {
                            AppRoutes.LOGIN
                        } else {
                            AppRoutes.ONBOARDING
                        }

                    navController.navigate(destination) {
                        popUpTo(AppRoutes.SPLASH) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(AppRoutes.ONBOARDING) {

            OnboardingScreen(
                onFinished = {

                    navController.navigate(
                        AppRoutes.LOGIN
                    ) {
                        popUpTo(AppRoutes.ONBOARDING) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(AppRoutes.LOGIN) {
             LoginScreen()
        }
    }
}
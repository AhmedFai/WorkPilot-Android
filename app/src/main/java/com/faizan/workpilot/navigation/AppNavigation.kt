package com.faizan.workpilot.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.faizan.workpilot.core.session.SessionViewModel
import com.faizan.workpilot.features.dashboard.admin.presentation.screen.AdminDashboardRoute
import com.faizan.workpilot.features.login.presentation.screen.LoginScreen
import com.faizan.workpilot.features.onboarding.presentation.screen.OnboardingScreen
import com.faizan.workpilot.features.splash.SplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val sessionViewModel: SessionViewModel =
        hiltViewModel()

    val isLoggedIn by sessionViewModel
        .isLoggedIn
        .collectAsStateWithLifecycle()

    LaunchedEffect(isLoggedIn) {

        if (!isLoggedIn) {

            navController.navigate(
                AppRoutes.LOGIN
            ) {
                popUpTo(0) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = AppRoutes.SPLASH
    ) {

        composable(AppRoutes.SPLASH) {

            SplashScreen(
                onSplashFinished = {
                        isOnboardingCompleted,
                        isLoggedIn ->

                    val destination =
                        when {
                            !isOnboardingCompleted ->
                                AppRoutes.ONBOARDING

                            isLoggedIn ->
                                AppRoutes.ADMIN_DASHBOARD

                            else ->
                                AppRoutes.LOGIN
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
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(AppRoutes.ADMIN_DASHBOARD) {
                        popUpTo(AppRoutes.LOGIN) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(AppRoutes.DASHBOARD) {
            Text("Dashboard")
        }

        composable(AppRoutes.ADMIN_DASHBOARD) {

            AdminDashboardRoute(

                onUsersClick = {
                    navController.navigate(
                        AppRoutes.USERS
                    )
                },

                onProjectsClick = {
                    navController.navigate(
                        AppRoutes.PROJECTS
                    )
                },

                onTasksClick = {
                    navController.navigate(
                        AppRoutes.TASKS
                    )
                },

                onReportsClick = {
                    navController.navigate(
                        AppRoutes.REPORTS
                    )
                },

                onProjectClick = { projectId ->
                    // later:
                    // navController.navigate(
                    //     "${AppRoutes.PROJECT_DETAILS}/$projectId"
                    // )
                },

                onSearchClick = {
                    // later
                },

                onProfileClick = {
                    // later
                },

                onNotificationClick = {
                    // later
                }
            )
        }
    }
}
package com.faizan.workpilot.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.faizan.workpilot.features.dashboard.admin.presentation.screen.AdminDashboardRoute
import com.faizan.workpilot.features.dashboard.employee.presentation.screen.EmployeeDashboardRoute
import com.faizan.workpilot.features.dashboard.projectHead.presentation.screen.ProjectHeadDashboardRoute
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

        // Splash
        composable(AppRoutes.SPLASH) {

            SplashScreen(
                onSplashFinished = {
                        isOnboardingCompleted,
                        isLoggedIn,
                        role ->

                    val destination = when {

                        !isOnboardingCompleted ->
                            AppRoutes.ONBOARDING

                        !isLoggedIn ->
                            AppRoutes.LOGIN

                        role == "ADMIN" ->
                            AppRoutes.ADMIN_DASHBOARD

                        role == "EMPLOYEE" ->
                            AppRoutes.EMPLOYEE_DASHBOARD

                        role == "PROJECT_HEAD" ->
                            AppRoutes.PROJECT_HEAD_DASHBOARD

                        role == "SUPER_ADMIN" ->
                            AppRoutes.ADMIN_DASHBOARD

                        else ->
                            AppRoutes.LOGIN
                    }

                    navController.navigate(destination) {

                        popUpTo(
                            AppRoutes.SPLASH
                        ) {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                }
            )
        }

        // Onboarding
        composable(AppRoutes.ONBOARDING) {

            OnboardingScreen(
                onFinished = {

                    navController.navigate(
                        AppRoutes.LOGIN
                    ) {

                        popUpTo(
                            AppRoutes.ONBOARDING
                        ) {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                }
            )
        }

        // Login
        composable(AppRoutes.LOGIN) {

            LoginScreen(
                onLoginSuccess = { role ->

                    val destination = when (role) {

                        "ADMIN" ->
                            AppRoutes.ADMIN_DASHBOARD

                        "EMPLOYEE" ->
                            AppRoutes.EMPLOYEE_DASHBOARD

                        "PROJECT_HEAD" ->
                            AppRoutes.PROJECT_HEAD_DASHBOARD

                        "SUPER_ADMIN" ->
                            AppRoutes.ADMIN_DASHBOARD

                        else ->
                            AppRoutes.LOGIN
                    }

                    navController.navigate(
                        destination
                    ) {

                        popUpTo(
                            AppRoutes.LOGIN
                        ) {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                }
            )
        }

        // Temporary
        composable(AppRoutes.DASHBOARD) {
            Text("Dashboard")
        }

        // Admin Dashboard
        composable(
            AppRoutes.ADMIN_DASHBOARD
        ) {

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

                onProjectClick = {
                    // Later
                },

                onSearchClick = {
                    // Later
                },

                onProfileClick = {
                    // Later
                },

                onNotificationClick = {
                    // Later
                }
            )
        }

        // Employee Dashboard
        composable(
            AppRoutes.EMPLOYEE_DASHBOARD
        ) {

            EmployeeDashboardRoute(

                onSearchClick = {
                    // Later
                },

                onProfileClick = {
                    // Later
                },

                onNotificationClick = {
                    // Later
                },

                onSortClick = {
                    // Later
                },

                onTaskClick = {
                    // Later
                }
            )
        }

        composable(
            AppRoutes.PROJECT_HEAD_DASHBOARD
        ) {
            ProjectHeadDashboardRoute(
                onSearchClick = {
                    // TODO
                },
                onProfileClick = {
                    // TODO
                },
                onNotificationClick = {
                    // TODO
                },
                onProjectClick = { projectId ->
                    // TODO
                }
            )
        }

    }
}
package com.faizan.workpilot.navigation

import com.faizan.workpilot.features.login.domain.model.UserSession

fun UserSession.dashboardRoute(): String {
    return when (role) {
        "ADMIN" -> AppRoutes.ADMIN_DASHBOARD
        "EMPLOYEE" -> AppRoutes.EMPLOYEE_DASHBOARD
        "PROJECT_HEAD" -> {
            // Later
            AppRoutes.EMPLOYEE_DASHBOARD
        }
        "SUPER_ADMIN" -> {
            // Later
            AppRoutes.ADMIN_DASHBOARD
        }
        else -> AppRoutes.LOGIN
    }
}
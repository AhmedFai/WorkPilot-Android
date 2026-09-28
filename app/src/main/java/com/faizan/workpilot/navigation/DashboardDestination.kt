package com.faizan.workpilot.navigation

import com.faizan.workpilot.features.login.domain.model.UserSession

fun UserSession.dashboardRoute(): String {
    return when (role) {
        "ADMIN" -> AppRoutes.ADMIN_DASHBOARD
        "EMPLOYEE" -> AppRoutes.EMPLOYEE_DASHBOARD
        "PROJECT_HEAD" -> AppRoutes.PROJECT_HEAD_DASHBOARD
        "SUPER_ADMIN" -> AppRoutes.SUPER_ADMIN_DASHBOARD
        else -> AppRoutes.LOGIN
    }
}
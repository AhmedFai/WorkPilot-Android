package com.faizan.workpilot.features.companyManagement.presentation.screen.companyStatus.components

import androidx.compose.ui.graphics.Color

data class CompanyStatusStyle(
    val containerColor: Color,
    val iconBackgroundColor: Color,
    val iconColor: Color,
    val titleColor: Color
)

object CompanyStatusStyles {

    val active = CompanyStatusStyle(
        containerColor = Color(0xFFE1F5E9),
        iconBackgroundColor = Color(0xFFCFF3DB),
        iconColor = Color(0xFF16A34A),
        titleColor = Color(0xFF15803D)
    )

    val inactive = CompanyStatusStyle(
        containerColor = Color(0xFFFDE7E7),
        iconBackgroundColor = Color(0xFFFFDADA),
        iconColor = Color(0xFFDC2626),
        titleColor = Color(0xFFB91C1C)
    )
}
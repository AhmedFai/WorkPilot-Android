package com.faizan.workpilot.features.companyManagement.presentation.screen.components

import androidx.compose.ui.graphics.Color

data class CompanyInfoIconStyle(
    val containerColor: Color,
    val iconColor: Color
)

object CompanyInfoIconColors {

    val companyName = CompanyInfoIconStyle(
        containerColor = Color(0xFFE8DEFF),
        iconColor = Color(0xFF5B4AE8)
    )

    val email = CompanyInfoIconStyle(
        containerColor = Color(0xFFE0E7FF),
        iconColor = Color(0xFF4F46E5)
    )

    val phone = CompanyInfoIconStyle(
        containerColor = Color(0xFFDDF7E8),
        iconColor = Color(0xFF16A34A)
    )

    val website = CompanyInfoIconStyle(
        containerColor = Color(0xFFDDF5F7),
        iconColor = Color(0xFF0891B2)
    )

    val address = CompanyInfoIconStyle(
        containerColor = Color(0xFFFFE4DC),
        iconColor = Color(0xFFF05A3C)
    )

    val city = CompanyInfoIconStyle(
        containerColor = Color(0xFFE4E7FF),
        iconColor = Color(0xFF4F46E5)
    )

    val state = CompanyInfoIconStyle(
        containerColor = Color(0xFFE0ECFF),
        iconColor = Color(0xFF2563EB)
    )

    val postalCode = CompanyInfoIconStyle(
        containerColor = Color(0xFFFFEBD2),
        iconColor = Color(0xFFEA8A00)
    )

    val country = CompanyInfoIconStyle(
        containerColor = Color(0xFFE0F0FF),
        iconColor = Color(0xFF1677C8)
    )

    val createdAt = CompanyInfoIconStyle(
        containerColor = Color(0xFFE8EDF5),
        iconColor = Color(0xFF526174)
    )

    val updatedAt = CompanyInfoIconStyle(
        containerColor = Color(0xFFEDE5FF),
        iconColor = Color(0xFF7652C7)
    )
}
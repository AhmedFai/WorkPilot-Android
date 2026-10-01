package com.faizan.workpilot.features.companyManagement.presentation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

data class CompanyActivityUi(
    val icon: ImageVector,
    val iconColor: Color,
    val iconBackgroundColor: Color,
    val relativeTime: String
)

fun getCompanyActivityUi(
    type: String,
    createdAt: String
): CompanyActivityUi {

    val visual = when (type.uppercase()) {

        "USER_CREATED" -> ActivityVisual(
            icon = Icons.Default.PersonAdd,
            iconColor = Color(0xFF6C5FFC),
            iconBackgroundColor = Color(0xFFF0EDFF)
        )

        "USER_DELETED" -> ActivityVisual(
            icon = Icons.Default.Delete,
            iconColor = Color(0xFFE53935),
            iconBackgroundColor = Color(0xFFFFEEEE)
        )

        "PROJECT_CREATED" -> ActivityVisual(
            icon = Icons.Default.Folder,
            iconColor = Color(0xFF2979FF),
            iconBackgroundColor = Color(0xFFEAF2FF)
        )

        "PROJECT_COMPLETED" -> ActivityVisual(
            icon = Icons.Default.CheckCircle,
            iconColor = Color(0xFF18B463),
            iconBackgroundColor = Color(0xFFEAF9F1)
        )

        "TASK_CREATED" -> ActivityVisual(
            icon = Icons.Default.TaskAlt,
            iconColor = Color(0xFF6C5FFC),
            iconBackgroundColor = Color(0xFFF0EDFF)
        )

        "TASK_COMPLETED" -> ActivityVisual(
            icon = Icons.Default.CheckCircle,
            iconColor = Color(0xFF18B463),
            iconBackgroundColor = Color(0xFFEAF9F1)
        )

        else -> ActivityVisual(
            icon = Icons.Default.Info,
            iconColor = Color(0xFF6B7280),
            iconBackgroundColor = Color(0xFFF1F3F5)
        )
    }

    return CompanyActivityUi(
        icon = visual.icon,
        iconColor = visual.iconColor,
        iconBackgroundColor = visual.iconBackgroundColor,
        relativeTime = formatActivityTime(createdAt)
    )
}

private data class ActivityVisual(
    val icon: ImageVector,
    val iconColor: Color,
    val iconBackgroundColor: Color
)

private fun formatActivityTime(
    createdAt: String
): String {

    return try {

        val createdTime = LocalDateTime.parse(
            createdAt,
            DateTimeFormatter.ISO_LOCAL_DATE_TIME
        )

        val createdInstant = createdTime
            .atZone(ZoneId.systemDefault())
            .toInstant()

        val now = java.time.Instant.now()

        val duration = Duration.between(
            createdInstant,
            now
        )

        when {

            duration.isNegative -> {
                "Just now"
            }

            duration.toMinutes() < 1 -> {
                "Just now"
            }

            duration.toMinutes() < 60 -> {
                "${duration.toMinutes()} min ago"
            }

            duration.toHours() < 24 -> {
                "${duration.toHours()} hours ago"
            }

            duration.toDays() < 7 -> {
                "${duration.toDays()} days ago"
            }

            else -> {
                "${duration.toDays() / 7} weeks ago"
            }
        }

    } catch (_: Exception) {
        ""
    }
}
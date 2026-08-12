package com.faizan.workpilot.core.ui.theme

import android.annotation.SuppressLint
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext

private val WorkPilotLightColorScheme = lightColorScheme(
    primary = WorkPilotPrimary,
    secondary = WorkPilotSecondary,
    background = WorkPilotBackground,
    surface = WorkPilotSurface,
    onBackground = WorkPilotTextPrimary,
    onSurface = WorkPilotTextPrimary,
    error = WorkPilotError
)

private val WorkPilotDarkColorScheme = darkColorScheme(
    primary = WorkPilotPrimary,
    secondary = WorkPilotSecondary,
    background = WorkPilotDarkBackground,
    surface = WorkPilotDarkSurface,
    onBackground = WorkPilotDarkTextPrimary,
    onSurface = WorkPilotDarkTextPrimary,
    error = WorkPilotError
)

@SuppressLint("ConfigurationScreenWidthHeight")
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun WorkPilotTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    @SuppressLint("ContextCastToActivity") activity: ComponentActivity = LocalContext.current as ComponentActivity,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current

            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> WorkPilotDarkColorScheme
        else -> WorkPilotLightColorScheme
    }

    val windowSizeClass = calculateWindowSizeClass(activity)
    val configuration = LocalConfiguration.current

    var appDimens = CompactDimens
    var typography = CompactTypography

    when (windowSizeClass.widthSizeClass) {

        WindowWidthSizeClass.Compact -> {
            if (configuration.screenWidthDp <= 360) {
                appDimens = CompactSmallDimens
                typography = CompactSmallTypography
            } else {
                appDimens = CompactDimens
                typography = CompactTypography
            }
        }

        WindowWidthSizeClass.Medium -> {
            appDimens = MediumDimens
            typography = MediumTypography
        }

        WindowWidthSizeClass.Expanded -> {
            appDimens = ExpandedDimens
            typography = ExpandedTypography
        }
    }

    AppUtils(
        appDimens = appDimens
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }
}
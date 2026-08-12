package com.faizan.workpilot.core.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(

    // Spacing
    val space2XS: Dp = 4.dp,
    val spaceXS: Dp = 8.dp,
    val spaceS: Dp = 12.dp,
    val spaceM: Dp = 16.dp,
    val spaceL: Dp = 24.dp,
    val spaceXL: Dp = 32.dp,
    val space2XL: Dp = 48.dp,
    val space3XL: Dp = 64.dp,
    val space4XL: Dp = 80.dp,

    // Screen
    val screenPaddingHorizontal: Dp = 16.dp,
    val screenPaddingVertical: Dp = 16.dp,

    // Common component sizes
    val toolbarHeight: Dp = 56.dp,
    val buttonHeight: Dp = 52.dp,
    val textFieldHeight: Dp = 56.dp,
    val minTouchTarget: Dp = 48.dp,

    // Icons
    val iconXS: Dp = 18.dp,
    val iconS: Dp = 24.dp,
    val iconM: Dp = 28.dp,
    val iconL: Dp = 40.dp,
    val iconXL: Dp = 56.dp,

    // Images / avatars
    val avatarS: Dp = 48.dp,
    val avatarM: Dp = 64.dp,
    val avatarL: Dp = 72.dp,

    // Logo
    val logoHeight: Dp = 80.dp,
    val logoWidth: Dp = 120.dp,

    // Radius
    val radiusS: Dp = 8.dp,
    val radiusM: Dp = 12.dp,
    val radiusL: Dp = 20.dp,
    val radiusXL: Dp = 24.dp,

    // Elevation
    val elevationS: Dp = 2.dp,
    val elevationM: Dp = 4.dp,
    val elevationL: Dp = 6.dp,
    val elevationXL: Dp = 8.dp

)


// 📱 COMPACT SMALL
// Small phones: width <= 360dp

val CompactSmallDimens = Dimens(
    // Spacing
    spaceXS = 6.dp,
    spaceS = 10.dp,
    spaceM = 12.dp,
    spaceL = 16.dp,
    spaceXL = 24.dp,
    space2XL = 36.dp,
    space3XL = 48.dp,
    space4XL = 64.dp,

    // Screen
    screenPaddingHorizontal = 12.dp,
    screenPaddingVertical = 12.dp,

    // Common components
    toolbarHeight = 52.dp,
    buttonHeight = 48.dp,
    textFieldHeight = 52.dp,

    // Icons
    iconXS = 16.dp,
    iconS = 20.dp,
    iconM = 24.dp,
    iconL = 36.dp,
    iconXL = 48.dp,

    // Images / avatars
    avatarS = 40.dp,
    avatarM = 48.dp,
    avatarL = 64.dp,

    // Logo
    logoHeight = 64.dp,
    logoWidth = 100.dp,

    // Radius
    radiusS = 8.dp,
    radiusM = 10.dp,
    radiusL = 16.dp,
    radiusXL = 20.dp
)


// 📱 COMPACT
// Normal phones — DEFAULT

val CompactDimens = Dimens()


// 📖 MEDIUM
// Large phones / unfolded foldables / small tablets

val MediumDimens = Dimens(
    // Spacing
    spaceXS = 10.dp,
    spaceS = 14.dp,
    spaceM = 20.dp,
    spaceL = 28.dp,
    spaceXL = 40.dp,
    space2XL = 56.dp,
    space3XL = 68.dp,
    space4XL = 88.dp,

    // Screen
    screenPaddingHorizontal = 24.dp,
    screenPaddingVertical = 20.dp,

    // Common components
    toolbarHeight = 60.dp,
    buttonHeight = 56.dp,
    textFieldHeight = 56.dp,

    // Icons
    iconXS = 20.dp,
    iconS = 28.dp,
    iconM = 32.dp,
    iconL = 44.dp,
    iconXL = 64.dp,

    // Images / avatars
    avatarS = 56.dp,
    avatarM = 72.dp,
    avatarL = 80.dp,

    // Logo
    logoHeight = 96.dp,
    logoWidth = 144.dp,

    // Radius
    radiusS = 8.dp,
    radiusM = 14.dp,
    radiusL = 20.dp,
    radiusXL = 24.dp
)


// 🖥️ EXPANDED
// Tablets / large screens

val ExpandedDimens = Dimens(
    // Spacing
    spaceXS = 12.dp,
    spaceS = 16.dp,
    spaceM = 24.dp,
    spaceL = 32.dp,
    spaceXL = 48.dp,
    space2XL = 64.dp,
    space3XL = 80.dp,
    space4XL = 100.dp,

    // Screen
    screenPaddingHorizontal = 32.dp,
    screenPaddingVertical = 24.dp,

    // Common components
    toolbarHeight = 64.dp,
    buttonHeight = 60.dp,
    textFieldHeight = 60.dp,

    // Icons
    iconXS = 24.dp,
    iconS = 32.dp,
    iconM = 36.dp,
    iconL = 48.dp,
    iconXL = 72.dp,

    // Images / avatars
    avatarS = 72.dp,
    avatarM = 88.dp,
    avatarL = 96.dp,

    // Logo
    logoHeight = 112.dp,
    logoWidth = 168.dp,

    // Radius
    radiusS = 8.dp,
    radiusM = 16.dp,
    radiusL = 24.dp,
    radiusXL = 28.dp
)

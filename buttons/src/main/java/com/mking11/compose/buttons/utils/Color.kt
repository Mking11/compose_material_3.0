package com.mking11.compose.buttons.utils

import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color

// default colors

val RedLight = Color(0xFFC8023E)
val LightPink = Color(0xFFF99697)

val lightPrimary = Color(0xFF1E69D2)
val lightPrimaryVariant = Color(0xFF0F3C97)
val lightSecondary = Color(0xFFB40F87)
val lightSecondaryVariant = Color(0xFF810778)
val lightBackground = Color(0xFFFFFFFF)
val lightSurface =  Color(0xFFFFFFFF)
val lightError = Color(0xFFC8023E)
val lightOnPrimary = Color(0xFFFFFFFF)
val lightOnSecondary =Color(0xFFFFFFFF)
val lightOnBackground = Color(0xFF000000)
val lightOnSurface = Color(0xFF000000)
val lightOnError = Color(0xFFFFFFFF)

val darkPrimary = Color(0xFF1E69D2)
val darkPrimaryVariant =  Color(0xFF0F3C97)
val darkSecondary =  Color(0xFFB40F87)
val darkSecondaryVariant =  Color(0xFF810778)
val darkBackground =  Color(0xFF191818)
val darkSurface =  Color(0xFF121212)
val darkError =  Color(0xFFC8023E)
val darkOnPrimary =  Color(0xFF000000)
val darkOnSecondary =  Color(0xFF000000)
val darkOnBackground =  Color(0xFFffffff)
val darkOnSurface =  Color(0xFFffffff)
val darkOnError =  Color(0xFF000000)

val LightColorPalette = darkColors(
    primary = lightPrimary,
    primaryVariant = lightPrimaryVariant,
    secondary = lightSecondary,
    secondaryVariant = lightSecondaryVariant,
    background = lightBackground,
    surface = lightSurface,
    error = lightError,
    onPrimary = lightOnPrimary,
    onSecondary = lightOnSecondary,
    onBackground = lightOnBackground,
    onSurface = lightOnSurface,
    onError = lightOnError
)


val DarkColorPalette = darkColors(
    primary = darkPrimary,
    primaryVariant = darkPrimaryVariant,
    secondary = darkSecondary,
    secondaryVariant = darkSecondaryVariant,
    background = darkBackground,
    surface = darkSurface,
    error = darkError,
    onPrimary = darkOnPrimary,
    onSecondary = darkOnSecondary,
    onBackground = darkOnBackground,
    onSurface = darkOnSurface,
    onError = darkOnError
)
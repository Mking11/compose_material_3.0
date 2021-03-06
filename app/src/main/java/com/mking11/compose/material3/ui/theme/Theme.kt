package com.mking11.compose.material3.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ComposeMaterial30Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val dynamicColors = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    if (dynamicColors) {
        val colors12 = if (darkTheme) {
            dynamicDarkColorScheme(LocalContext.current)
        } else {
            dynamicLightColorScheme(LocalContext.current)

        }

        MaterialTheme(
            colorScheme = colors12,
            typography = Typography12,
            content = content
        )
    } else {
        val colors =
            if (darkTheme) com.mking11.compose.buttons.utils.DarkColorPalette else com.mking11.compose.buttons.utils.LightColorPalette
        androidx.compose.material.MaterialTheme(colors = colors, typography = Typography) {
            content()
        }
    }


}
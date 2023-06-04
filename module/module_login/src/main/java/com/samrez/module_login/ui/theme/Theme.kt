package com.samrez.module_login.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = primaryColor,
    primaryVariant = purple700,
    secondary = teal200
)

private val LightColorPalette = lightColors(
    primary = primaryColor,
    primaryVariant = purple700,
    secondary = teal200
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
fun LoginApplicationTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
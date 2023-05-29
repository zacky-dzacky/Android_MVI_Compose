package id.syarief.base.base_component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color.Blue,
    primaryVariant = Color.Blue,
    secondary = Color.Blue
)

private val LightColorPalette = lightColors(
    primary = Color.Blue,
    primaryVariant = Color.Blue,
    secondary = Color.Blue,
    background = Color.White

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
fun BaseTheme(darkTheme: Boolean = isSystemInDarkTheme(),  content: @Composable () -> Unit) {

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        content = content
    )
}
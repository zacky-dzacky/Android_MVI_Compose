package id.syarief.base.base_component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColorScheme(
    primary = Color.Blue,
    onPrimary = Color.Blue,
    secondary = Color.Blue,
    background = Color.White
)

private val LightColorPalette = lightColorScheme(
    primary = Color.Blue,
    onPrimary = Color.Blue,
    secondary = Color.Blue,
    background = Color.LightGray

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
        colorScheme = colors,
        content = content
    )
}
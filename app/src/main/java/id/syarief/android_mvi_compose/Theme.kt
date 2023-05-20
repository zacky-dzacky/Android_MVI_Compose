package id.syarief.android_mvi_compose

import androidx.compose.runtime.Composable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

@Composable
fun BaseTheme(content: @Composable () -> Unit) {

    val colors = lightColors(
        primary = Color.Blue,
        primaryVariant = Color.Cyan,
        secondary = Color.Blue,
    )
    MaterialTheme(
        colors = colors,
        content = content
    )
}
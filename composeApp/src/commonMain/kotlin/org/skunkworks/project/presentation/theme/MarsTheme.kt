package org.skunkworks.project.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val MarsRed = Color(0xFFB5473B)
private val MarsRedDark = Color(0xFF8B2E24)
private val MarsRedLight = Color(0xFFD4736A)
private val MarsDust = Color(0xFFC9A07A)
private val MarsGrey = Color(0xFF4A4A4A)
private val MarsGreyLight = Color(0xFF6E6E6E)
private val MarsSurface = Color(0xFFF5EDE6)
private val MarsSurfaceVariant = Color(0xFFE8DDD3)
private val MarsOnSurface = Color(0xFF2C2420)

private val MarsLightColors = lightColorScheme(
    primary = MarsRed,
    onPrimary = Color.White,
    primaryContainer = MarsRedLight,
    onPrimaryContainer = Color.White,
    secondary = MarsDust,
    onSecondary = MarsOnSurface,
    secondaryContainer = MarsDust.copy(alpha = 0.5f),
    onSecondaryContainer = MarsOnSurface,
    background = MarsSurface,
    onBackground = MarsOnSurface,
    surface = MarsSurface,
    onSurface = MarsOnSurface,
    surfaceVariant = MarsSurfaceVariant,
    onSurfaceVariant = MarsGrey,
    error = Color(0xFFB3261E),
    onError = Color.White
)

private val MarsDarkColors = darkColorScheme(
    primary = MarsRedLight,
    onPrimary = Color.White,
    primaryContainer = MarsRedDark,
    onPrimaryContainer = Color.White,
    secondary = MarsDust,
    onSecondary = MarsOnSurface,
    secondaryContainer = MarsGrey,
    onSecondaryContainer = MarsDust,
    background = Color(0xFF1C1410),
    onBackground = MarsSurface,
    surface = Color(0xFF2C2420),
    onSurface = MarsSurface,
    surfaceVariant = MarsGrey,
    onSurfaceVariant = MarsDust,
    error = Color(0xFFF2B8B5),
    onError = Color(0xFF601410)
)

@Composable
fun MarsTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) MarsDarkColors else MarsLightColors,
        content = content
    )
}
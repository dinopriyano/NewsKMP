package com.dino.newskmp.app.common.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
  primary = Dark,
  secondary = SecondaryDark,
  tertiary = TertiaryDark,
  background = Dark,
  onBackground = Color.White
)

private val LightColorScheme = lightColorScheme(
  primary = Dark,
  secondary = SecondaryDark,
  tertiary = TertiaryDark,
  background = Dark,
  onBackground = Color.White
)

@Composable fun NewsKMPTheme(
  darkTheme: Boolean = isSystemInDarkTheme(), // Dynamic color is available on Android 12+
  content: @Composable () -> Unit
) {
  val colorScheme = when {
    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }

  MaterialTheme(
    colorScheme = colorScheme, typography = getTypography(), content = content
  )
}
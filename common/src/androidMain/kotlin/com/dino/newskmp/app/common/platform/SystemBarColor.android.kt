package com.dino.newskmp.app.common.platform

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * Created by dinopriyano on 11/11/23.
 */

@Composable
actual fun SystemBarColor(statusBarColor: Color, navigationBarColor: Color) {
  val view = LocalView.current
  SideEffect {
    val window = (view.context as Activity).window
    window.statusBarColor = statusBarColor.toArgb()
    window.navigationBarColor = navigationBarColor.toArgb()
    WindowCompat.getInsetsController(window, view)
  }
}
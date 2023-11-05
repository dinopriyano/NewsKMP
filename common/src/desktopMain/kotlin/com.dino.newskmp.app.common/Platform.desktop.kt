package com.dino.newskmp.app.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

/**
 * Created by dinopriyano on 04/11/23.
 */

actual fun getPlatformName(): String = "Desktop"

@Composable
actual fun getFont(name: String, res: String, weight: FontWeight, style: FontStyle): Font =
  androidx.compose.ui.text.platform.Font("font/$res.ttf", weight, style)
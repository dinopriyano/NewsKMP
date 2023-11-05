package com.dino.newskmp.app.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

/**
 * Created by dinopriyano on 04/11/23.
 */

actual fun getPlatformName(): String = "iOS"

private val cache: MutableMap<String, Font> = mutableMapOf()
@OptIn(ExperimentalResourceApi::class)
@Composable
actual fun getFont(name: String, res: String, weight: FontWeight, style: FontStyle): Font {
  return cache.getOrPut(res) {
    val byteArray = runBlocking {
      resource("font/$res.ttf").readBytes()
    }
    androidx.compose.ui.text.platform.Font(res, byteArray, weight, style)
  }
}
package com.dino.newskmp.app.common.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dino.newskmp.app.SharedRes
import dev.icerock.moko.resources.compose.asFont

@Composable
fun getTypography(): Typography {

  val nexaFontFamily = FontFamily(
    SharedRes.fonts.nexa_extra_light.nexa_extra_light.asFont(weight = FontWeight.ExtraLight)!!,
    SharedRes.fonts.nexa_regular.nexa_regular.asFont(weight = FontWeight.Normal)!!,
    SharedRes.fonts.nexa_heavy.nexa_heavy.asFont(weight = FontWeight.Bold)!!,
  )

  val outfitFontFamily = FontFamily(
    SharedRes.fonts.outfit_regular.outfit_regular.asFont(weight = FontWeight.Normal)!!,
    SharedRes.fonts.outfit_medium.outfit_medium.asFont(weight = FontWeight.Medium)!!,
    SharedRes.fonts.outfit_bold.outfit_bold.asFont(weight = FontWeight.Bold)!!,
  )

  return Typography(
    bodySmall = TextStyle(
      fontFamily = outfitFontFamily,
      fontWeight = FontWeight.Normal,
      fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
      fontFamily = outfitFontFamily,
      fontWeight = FontWeight.Normal,
      fontSize = 16.sp
    ),
    labelSmall = TextStyle(
      fontFamily = outfitFontFamily,
      fontWeight = FontWeight.Medium,
      fontSize = 14.sp
    ),
    labelMedium = TextStyle(
      fontFamily = outfitFontFamily,
      fontWeight = FontWeight.Medium,
      fontSize = 16.sp
    ),
    labelLarge = TextStyle(
      fontFamily = outfitFontFamily,
      fontWeight = FontWeight.Medium,
      fontSize = 24.sp
    ),
    titleSmall = TextStyle(
      fontFamily = nexaFontFamily,
      fontWeight = FontWeight.Bold,
      fontSize = 16.sp
    ),
    titleMedium = TextStyle(
      fontFamily = nexaFontFamily,
      fontWeight = FontWeight.Bold,
      fontSize = 24.sp
    ),
    titleLarge = TextStyle(
      fontFamily = nexaFontFamily,
      fontWeight = FontWeight.Bold,
      fontSize = 26.sp
    )
  )
}
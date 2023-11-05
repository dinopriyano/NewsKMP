package com.dino.newskmp.app.common.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dino.newskmp.app.SharedRes
import dev.icerock.moko.resources.compose.asFont

@Composable
fun getTypography(): Typography {
  val nexaRegular = FontFamily(
    SharedRes.fonts.nexa_regular.nexa_regular.asFont(FontWeight.Normal, FontStyle.Normal)!!
  )
  val nexaExtraLight = FontFamily(
    SharedRes.fonts.nexa_extra_light.nexa_extra_light.asFont(FontWeight.ExtraLight, FontStyle.Normal)!!
  )
  val nexaHeavy = FontFamily(
    SharedRes.fonts.nexa_heavy.nexa_heavy.asFont(FontWeight.Bold, FontStyle.Normal)!!
  )
  val outfitRegular = FontFamily(
    SharedRes.fonts.outfit_regular.outfit_regular.asFont(FontWeight.Normal, FontStyle.Normal)!!
  )
  val outfitMedium = FontFamily(
    SharedRes.fonts.outfit_medium.outfit_medium.asFont(FontWeight.Medium, FontStyle.Normal)!!
  )
  val outfitBold = FontFamily(
    SharedRes.fonts.outfit_bold.outfit_bold.asFont(FontWeight.Bold, FontStyle.Normal)!!
  )

  return Typography(
    bodySmall = TextStyle(
      fontFamily = outfitRegular,
      fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
      fontFamily = outfitRegular,
      fontSize = 16.sp
    ),
    titleSmall = TextStyle(
      fontFamily = nexaHeavy,
      fontSize = 16.sp
    ),
    titleMedium = TextStyle(
      fontFamily = nexaHeavy,
      fontSize = 24.sp
    ),
    titleLarge = TextStyle(
      fontFamily = nexaHeavy,
      fontSize = 26.sp
    )
  )
}
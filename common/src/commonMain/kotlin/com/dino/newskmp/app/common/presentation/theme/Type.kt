package com.dino.newskmp.app.common.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dino.newskmp.app.common.getFont

@Composable
fun getTypography(): Typography {
  val nexaRegular = FontFamily(
    getFont("Nexa","nexa_regular", FontWeight.Normal, FontStyle.Normal)
  )
  val nexaExtraLight = FontFamily(
    getFont("Nexa", "nexa_extra_light", FontWeight.ExtraLight, FontStyle.Normal)
  )
  val nexaHeavy = FontFamily(
    getFont("Nexa", "nexa_heavy", FontWeight.Bold, FontStyle.Normal)
  )
  val outfitRegular = FontFamily(
    getFont("Outfit", "outfit_regular", FontWeight.Normal, FontStyle.Normal)
  )
  val outfitMedium = FontFamily(
    getFont("Outfit", "outfit_medium", FontWeight.Medium, FontStyle.Normal)
  )
  val outfitBold = FontFamily(
    getFont("Outfit", "outfit_bold", FontWeight.Bold, FontStyle.Normal)
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
      fontSize = 32.sp
    )
  )
}
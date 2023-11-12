package com.dino.newskmp.app.common.utils

import androidx.compose.ui.graphics.Color
import com.dino.newskmp.app.common.presentation.theme.BluePastel
import com.dino.newskmp.app.common.presentation.theme.PinkPastel
import com.dino.newskmp.app.common.presentation.theme.YellowPastel

/**
 * Created by dinopriyano on 12/11/23.
 */

fun getCardColor(currentIndex: Int): Color {
  return when (currentIndex % 3) {
    0 -> YellowPastel
    1 -> PinkPastel
    else -> BluePastel
  }
}
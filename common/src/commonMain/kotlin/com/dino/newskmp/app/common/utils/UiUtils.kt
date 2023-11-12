package com.dino.newskmp.app.common.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.dino.newskmp.app.SharedRes
import com.dino.newskmp.app.common.platform.DateTime
import com.dino.newskmp.app.common.presentation.theme.BluePastel
import com.dino.newskmp.app.common.presentation.theme.PinkPastel
import com.dino.newskmp.app.common.presentation.theme.PurplePastel
import com.dino.newskmp.app.common.presentation.theme.YellowPastel
import dev.icerock.moko.resources.compose.stringResource
import dev.icerock.moko.resources.desc.Plural
import dev.icerock.moko.resources.desc.StringDesc
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

/**
 * Created by dinopriyano on 12/11/23.
 */

fun getCardColor(currentIndex: Int): Color {
  return when (currentIndex % 4) {
    0 -> YellowPastel
    1 -> PinkPastel
    2 -> BluePastel
    else -> PurplePastel
  }
}

@Composable
fun formatToTimeAgo(isoDate: String): String {
  val dateTime = DateTime()
  val now = Clock.System.now()
  val then = Instant.parse(isoDate)
  val duration = now - then

  val seconds = duration.inWholeSeconds
  val minutes = seconds / 60
  val hours = minutes / 60
  val days = hours / 24
  val weeks = days / 7
  val months = days / 30

  return when {
    months > 0 -> dateTime.getFormattedDate(isoDate, "dd MMMM yyyy")
    weeks > 0 -> "$weeks ${stringResource(SharedRes.plurals.template_week_ago, weeks.toInt())}"
    days > 0 -> "$days ${stringResource(SharedRes.plurals.template_day_ago, days.toInt())}"
    hours > 0 -> "$hours ${stringResource(SharedRes.plurals.template_hour_ago, hours.toInt())}"
    minutes > 0 -> "$minutes ${stringResource(SharedRes.plurals.template_minute_ago, minutes.toInt())}"
    else -> stringResource(SharedRes.strings.just_now_txt)
  }
}
package com.dino.newskmp.app.common.presentation.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.dino.newskmp.app.SharedRes
import com.dino.newskmp.app.common.presentation.screen.home.HomeScreen
import dev.icerock.moko.resources.compose.painterResource

/**
 * Created by dinopriyano on 05/11/23.
 */

internal object HomeTab: Tab {

  @Composable
  override fun Content() {
    HomeScreen()
  }

  override val options: TabOptions
    @Composable
    get() {
      val icon = painterResource(SharedRes.images.home_outlined)
      return remember { TabOptions(index = 0u, title = "Home", icon = icon) }
    }
}
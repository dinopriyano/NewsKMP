package com.dino.newskmp.app.common.presentation.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.dino.newskmp.app.common.presentation.screen.home.HomeScreen
import com.dino.newskmp.app.common.presentation.screen.home.HomeScreenViewModel
import org.koin.compose.koinInject

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
      val icon = rememberVectorPainter(Icons.Rounded.Home)
      return remember { TabOptions(index = 0u, title = "Home", icon = icon) }
    }

}
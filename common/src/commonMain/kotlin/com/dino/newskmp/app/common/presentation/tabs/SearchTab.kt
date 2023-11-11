package com.dino.newskmp.app.common.presentation.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.dino.newskmp.app.SharedRes
import com.dino.newskmp.app.common.presentation.screen.search.SearchScreen
import dev.icerock.moko.resources.compose.painterResource

/**
 * Created by dinopriyano on 05/11/23.
 */

internal object SearchTab: Tab {

  @Composable
  override fun Content() {
    SearchScreen()
  }

  override val options: TabOptions
    @Composable
    get() {
      val icon = painterResource(SharedRes.images.search_outlined)
      return remember { TabOptions(index = 1u, title = "Search", icon = icon) }
    }
}
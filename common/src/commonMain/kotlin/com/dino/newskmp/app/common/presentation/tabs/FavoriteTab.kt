package com.dino.newskmp.app.common.presentation.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.dino.newskmp.app.common.presentation.screen.favorite.FavoriteScreen

/**
 * Created by dinopriyano on 05/11/23.
 */

internal object FavoriteTab: Tab {

  @Composable
  override fun Content() {
    FavoriteScreen()
  }

  override val options: TabOptions
    @Composable
    get() {
      val icon = rememberVectorPainter(Icons.Rounded.Bookmark)
      return remember { TabOptions(index = 2u, title = "Bookmark", icon = icon) }
    }

}
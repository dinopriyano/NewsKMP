package com.dino.newskmp.app.common.presentation.tabs

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import com.dino.newskmp.app.common.presentation.screen.favorite.FavoriteScreen

/**
 * Created by dinopriyano on 05/11/23.
 */

object FavoriteTab: Tab {

  @Composable
  override fun Content() {
    Navigator(screen = FavoriteScreen()) {
      SlideTransition(it)
    }
  }

  override val options: TabOptions
    @Composable
    get() {
      return remember { TabOptions(index = 2u, title = "Bookmark") }
    }

}
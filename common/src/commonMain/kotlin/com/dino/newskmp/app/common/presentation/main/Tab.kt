package com.dino.newskmp.app.common.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import com.dino.newskmp.app.SharedRes
import com.dino.newskmp.app.common.presentation.tabs.FavoriteTab
import com.dino.newskmp.app.common.presentation.tabs.HomeTab
import com.dino.newskmp.app.common.presentation.tabs.SearchTab
import dev.icerock.moko.resources.ImageResource

/**
 * Created by dinopriyano on 11/11/23.
 */

@Composable fun rememberTabs(): List<TabContainer> {
  return remember {
    listOf(
      TabContainer(
        HomeTab,
        SharedRes.images.home_filled,
        SharedRes.images.home_outlined
      ),
      TabContainer(
        SearchTab,
        SharedRes.images.search_filled,
        SharedRes.images.search_outlined
      ),
      TabContainer(
        FavoriteTab,
        SharedRes.images.bookmark_filled,
        SharedRes.images.bookmark_outlined
      )
    )
  }
}

data class TabContainer(
  val tab: Tab,
  val selectedIcon: ImageResource,
  val unSelectedIcon: ImageResource,
)
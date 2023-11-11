package com.dino.newskmp.app.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.dino.newskmp.app.SharedRes
import com.dino.newskmp.app.common.platform.SystemBarColor
import com.dino.newskmp.app.common.presentation.component.RawrBottomNavigationItem
import com.dino.newskmp.app.common.presentation.tabs.FavoriteTab
import com.dino.newskmp.app.common.presentation.tabs.HomeTab
import com.dino.newskmp.app.common.presentation.tabs.SearchTab
import com.dino.newskmp.app.common.presentation.theme.NewsKMPTheme
import dev.icerock.moko.resources.compose.painterResource

/**
 * Created by dinopriyano on 04/11/23.
 */

val itemSize = 56.dp
val filledIconList = listOf(
  SharedRes.images.home_filled,
  SharedRes.images.search_filled,
  SharedRes.images.bookmark_filled
)

@Composable fun NewsApp() {
  NewsKMPTheme {
    SystemBarColor(
      statusBarColor = MaterialTheme.colorScheme.background,
      navigationBarColor = MaterialTheme.colorScheme.background
    )
    TabNavigator(HomeTab) {
      Navigator(Application())
    }
  }
}

class Application: Screen {

  @Composable
  override fun Content() {
    Box(
      modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
      contentAlignment = Alignment.BottomCenter
    ) {
      CurrentTab()
      Row(
        Modifier
          .padding(bottom = 24.dp)
          .shadow(4.dp, RoundedCornerShape(CornerSize(50)))
          .clip(RoundedCornerShape(CornerSize(50)))
          .background(MaterialTheme.colorScheme.secondary)
          .padding(5.dp)
          .selectableGroup(),
        horizontalArrangement = Arrangement.spacedBy(5.dp))
      {
        TabNavigationItem(HomeTab)
        TabNavigationItem(SearchTab)
        TabNavigationItem(FavoriteTab)
      }
    }
  }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
  val tabNavigator = LocalTabNavigator.current
  val isSelected = tabNavigator.current.key == tab.key
  val (iconColor, iconBackground, icon) = if (isSelected) {
    Triple(
      MaterialTheme.colorScheme.background, MaterialTheme.colorScheme.onBackground, painterResource(
        filledIconList[tab.options.index.toInt()]
      )
    )
  } else {
    Triple(
      MaterialTheme.colorScheme.onBackground,
      MaterialTheme.colorScheme.tertiary,
      tab.options.icon!!
    )
  }
  RawrBottomNavigationItem(
    modifier = Modifier.size(itemSize).clip(CircleShape).background(iconBackground),
    unselectedContentColor = MaterialTheme.colorScheme.onBackground,
    selectedContentColor = MaterialTheme.colorScheme.background,
    selected = isSelected,
    onClick = { tabNavigator.current = tab },
    icon = { Icon(painter = icon, contentDescription = tab.options.title, tint = iconColor) })
}
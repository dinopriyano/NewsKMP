package com.dino.newskmp.app.common

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.dino.newskmp.app.common.presentation.tabs.FavoriteTab
import com.dino.newskmp.app.common.presentation.tabs.HomeTab
import com.dino.newskmp.app.common.presentation.tabs.SearchTab
import com.dino.newskmp.app.common.presentation.theme.NewsKMPTheme

/**
 * Created by dinopriyano on 04/11/23.
 */

@Composable fun NewsApp() {
  NewsKMPTheme {
    TabNavigator(HomeTab) {
      Navigator(Application())
    }
  }
}

class Application: Screen {

  @Composable
  override fun Content() {
    Scaffold(
      modifier = Modifier,
      scaffoldState = rememberScaffoldState(),
      bottomBar = {
        BottomNavigation(
          modifier = Modifier.wrapContentWidth(),
          backgroundColor = MaterialTheme.colorScheme.background,
          elevation = 4.dp
        ) {
          TabNavigationItem(HomeTab)
          TabNavigationItem(SearchTab)
          TabNavigationItem(FavoriteTab)
        }
      }
    ) {
      CurrentTab()
    }
  }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
  val tabNavigator = LocalTabNavigator.current
  BottomNavigationItem(
    modifier = Modifier,
    unselectedContentColor = MaterialTheme.colorScheme.onBackground,
    selectedContentColor = MaterialTheme.colorScheme.background,
    selected = tabNavigator.current.key == tab.key,
    onClick = { tabNavigator.current = tab },
    icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title) })
}
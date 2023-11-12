package com.dino.newskmp.app.common.presentation.main

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.dino.newskmp.app.common.platform.SystemBarColor
import com.dino.newskmp.app.common.presentation.component.RawrBottomNavigationItem
import com.dino.newskmp.app.common.presentation.tabs.HomeTab
import com.dino.newskmp.app.common.presentation.theme.LightTransparent
import com.dino.newskmp.app.common.presentation.theme.NewsKMPTheme
import com.dino.newskmp.app.common.utils.drawCircleIndicator
import dev.icerock.moko.resources.compose.painterResource

/**
 * Created by dinopriyano on 04/11/23.
 */

val itemSize = 56.dp

@Composable fun NewsApp() {
  NewsKMPTheme {
    SystemBarColor(
      statusBarColor = MaterialTheme.colorScheme.background,
      navigationBarColor = MaterialTheme.colorScheme.background
    )
    Application().Content()
  }
}

class Application: Screen {

  @Composable
  override fun Content() {
    val tabs = rememberTabs()

    TabNavigator(HomeTab) {
      Box(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.BottomCenter
      ) {
        CurrentTab()
        BottomBar(tabs)
      }
    }
  }
}

@Composable fun BottomBar(tab: List<TabContainer>) {

  var xIndicatorOffset by remember { mutableStateOf(Float.NaN) }
  val xOffsetAnimated by animateFloatAsState(targetValue = xIndicatorOffset)

  Row(
    Modifier
      .padding(bottom = 24.dp)
      .shadow(4.dp, RoundedCornerShape(CornerSize(50)))
      .clip(RoundedCornerShape(CornerSize(50)))
      .background(MaterialTheme.colorScheme.secondary)
      .padding(5.dp)
      .selectableGroup()
      .drawCircleIndicator(xOffsetAnimated),
    horizontalArrangement = Arrangement.spacedBy(5.dp))
  {
    tab.forEach { tab ->
      TabNavigationItem(
        tabContainer = tab,
      ) { offsets ->
        xIndicatorOffset = offsets
      }
    }
  }
}

@Composable
private fun RowScope.TabNavigationItem(tabContainer: TabContainer, onSelected: (offsets: Float) -> Unit) {
  val tabNavigator = LocalTabNavigator.current
  val isSelected = tabNavigator.current.key == tabContainer.tab.key
  val (iconColor, icon, iconSize) = if (isSelected) {
    Triple(
      MaterialTheme.colorScheme.background,
      painterResource(tabContainer.selectedIcon),
      32.dp
    )
  } else {
    Triple(
      MaterialTheme.colorScheme.onBackground,
      painterResource(tabContainer.unSelectedIcon),
      24.dp
    )
  }
  val animatedIconSize by animateDpAsState(
    targetValue = iconSize,
    animationSpec = spring(
      stiffness = Spring.StiffnessLow,
      dampingRatio = Spring.DampingRatioHighBouncy
    )
  )
  RawrBottomNavigationItem(
    modifier = Modifier
      .size(itemSize)
      .clip(CircleShape)
      .background(LightTransparent)
      .onGloballyPositioned { layoutCoordinates ->
        if (isSelected) {
          val parentLayoutCoordinates = layoutCoordinates.parentLayoutCoordinates!!
          val parentPosition = parentLayoutCoordinates.positionInRoot()
          val itemCenterX = layoutCoordinates.positionInRoot().x - parentPosition.x + layoutCoordinates.size.width / 2
          onSelected(itemCenterX)
        }
      },
    unselectedContentColor = MaterialTheme.colorScheme.onBackground,
    selectedContentColor = MaterialTheme.colorScheme.background,
    selected = isSelected,
    onClick = { tabNavigator.current = tabContainer.tab },
    icon = {
      Icon(
        painter = icon,
        contentDescription = tabContainer.tab.options.title,
        tint = iconColor,
        modifier = Modifier.size(animatedIconSize)
      )
    }
  )
}
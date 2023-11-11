package com.dino.newskmp.app.common.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import com.dino.newskmp.app.SharedRes
import com.dino.newskmp.app.common.data.DummyData
import com.dino.newskmp.app.common.presentation.base.BaseScreen
import com.dino.newskmp.app.common.presentation.component.RawrChip
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

/**
 * Created by dinopriyano on 05/11/23.
 */

class HomeScreen: BaseScreen<HomeScreenModel, HomeScreenUiState, HomeScreenUiEffect, HomeScreenInteractionListener>() {

  @Composable
  override fun Content() {
    initScreen(getScreenModel())
  }

  @Composable
  override fun onRender(state: HomeScreenUiState, listener: HomeScreenInteractionListener) {
    var selectedCategoryIndex by rememberSaveable { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
      // Home header
      TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colorScheme.background,
        elevation = 0.dp
      ) {
        Icon(
          painter = painterResource(SharedRes.images.ic_news_light),
          modifier = Modifier.padding(start = 24.dp).size(42.dp),
          tint = Color.Unspecified,
          contentDescription = null
        )
        Spacer(Modifier.width(8.dp))
        Text(
          text = stringResource(SharedRes.strings.title),
          style = MaterialTheme.typography.titleLarge,
          color = MaterialTheme.colorScheme.onBackground
        )
      }

      // Category
      LazyRow (
        modifier = Modifier.padding(top = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 24.dp)
      ) {
        itemsIndexed(DummyData.categories) { index, item ->
          RawrChip(
            item,
            index == selectedCategoryIndex,
            Modifier
          ) { title ->
            selectedCategoryIndex = index
          }
        }
      }

      // Slider content

    }
  }

  override fun onEffect(effect: HomeScreenUiEffect, navigator: Navigator) {
    // TODO: Not yet implemented
  }
}


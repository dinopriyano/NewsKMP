package com.dino.newskmp.app.common.presentation.screen.favorite

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.dino.newskmp.app.common.presentation.base.BaseScreen

/**
 * Created by dinopriyano on 05/11/23.
 */

class FavoriteScreen: BaseScreen<FavoriteScreenModel, FavoriteScreenUiState, FavoriteScreenUiEffect, FavoriteScreenInteractionListener>() {

  @Composable
  override fun Content() {
    initScreen(getScreenModel())
  }

  @Composable
  override fun onRender(state: FavoriteScreenUiState, listener: FavoriteScreenInteractionListener) {
    Text(modifier = Modifier.fillMaxSize(), text = "Favorite Screen")
  }

  override fun onEffect(effect: FavoriteScreenUiEffect, navigator: Navigator) {
    // TODO: Not yet implemented
  }
}
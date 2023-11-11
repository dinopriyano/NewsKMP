package com.dino.newskmp.app.common.presentation.screen.favorite

import cafe.adriel.voyager.core.model.coroutineScope
import com.dino.newskmp.app.common.presentation.base.BaseScreenModel
import kotlinx.coroutines.CoroutineScope

/**
 * Created by dinopriyano on 05/11/23.
 */
class FavoriteScreenModel: BaseScreenModel<FavoriteScreenUiState, FavoriteScreenUiEffect>(FavoriteScreenUiState()), FavoriteScreenInteractionListener {

  override val viewModelScope: CoroutineScope = coroutineScope



}
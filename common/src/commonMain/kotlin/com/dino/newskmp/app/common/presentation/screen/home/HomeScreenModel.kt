package com.dino.newskmp.app.common.presentation.screen.home

import cafe.adriel.voyager.core.model.coroutineScope
import com.dino.newskmp.app.common.presentation.base.BaseScreenModel
import kotlinx.coroutines.CoroutineScope

/**
 * Created by dinopriyano on 05/11/23.
 */
class HomeScreenModel: BaseScreenModel<HomeScreenUiState, HomeScreenUiEffect>(HomeScreenUiState()), HomeScreenInteractionListener {

  override val viewModelScope: CoroutineScope = coroutineScope



}
package com.dino.newskmp.app.common.presentation.screen.search

import cafe.adriel.voyager.core.model.coroutineScope
import com.dino.newskmp.app.common.presentation.base.BaseScreenModel
import kotlinx.coroutines.CoroutineScope

/**
 * Created by dinopriyano on 05/11/23.
 */
class SearchScreenModel: BaseScreenModel<SearchScreenUiState, SearchScreenUiEffect>(SearchScreenUiState()), SearchScreenInteractionListener {

  override val viewModelScope: CoroutineScope = coroutineScope



}
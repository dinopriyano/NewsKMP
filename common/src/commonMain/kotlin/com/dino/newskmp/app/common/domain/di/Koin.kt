package com.dino.newskmp.app.common.domain.di

import com.dino.newskmp.app.common.presentation.screen.favorite.FavoriteScreenModel
import com.dino.newskmp.app.common.presentation.screen.home.HomeScreenModel
import com.dino.newskmp.app.common.presentation.screen.search.SearchScreenModel
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

/**
 * Created by dinopriyano on 05/11/23.
 */

// Called by android
fun initKoin(
  enableNetworkLogs: Boolean = false,
  baseUrl: String,
  appDeclaration: KoinAppDeclaration = {}
) = startKoin {
  appDeclaration()
  modules(commonModule(enableNetworkLogs, baseUrl))
}

fun initKoin(baseUrl: String) = initKoin(enableNetworkLogs = true, baseUrl = baseUrl) {}

fun commonModule(
  enableNetworkLogs: Boolean,
  baseUrl: String
) = getScreenModule()

fun getScreenModule() = module {
  single { HomeScreenModel() }
  single { SearchScreenModel() }
  single { FavoriteScreenModel() }
}
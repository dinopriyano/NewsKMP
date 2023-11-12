package com.dino.newskmp.app.common.platform

import com.dino.newskmp.app.common.common.config.Platform
import io.ktor.client.engine.darwin.Darwin
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSLocale
import platform.Foundation.preferredLanguages

/**
 * Created by dinopriyano on 04/11/23.
 */

actual val ioDispatcher: CoroutineDispatcher
  get() = Dispatchers.Default

actual val currentDeviceLanguage: String
  get() = NSLocale.preferredLanguages.first().toString().substring(0..1)

actual val currentPlatform: Platform
  get() = Platform.IOS

actual val platformNetworkEngineModule: Module
  get() = module { single { Darwin.create() } }
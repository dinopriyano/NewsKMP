package com.dino.newskmp.app.common.platform

import com.dino.newskmp.app.common.common.config.Platform
import io.ktor.client.engine.cio.CIO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.dsl.module
import java.util.Locale

/**
 * Created by dinopriyano on 04/11/23.
 */

actual val ioDispatcher: CoroutineDispatcher
  get() = Dispatchers.IO

actual val currentDeviceLanguage: String
  get() = Locale.getDefault().language

actual val currentPlatform: Platform
  get() = Platform.DESKTOP

actual val platformNetworkEngineModule: Module
  get() = module { single { CIO.create() } }
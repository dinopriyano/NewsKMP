package com.dino.newskmp.app.common.platform

import com.dino.newskmp.app.common.common.config.Platform
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.module.Module

/**
 * Created by dinopriyano on 04/11/23.
 */

expect val ioDispatcher: CoroutineDispatcher

expect val currentDeviceLanguage: String

expect val currentPlatform: Platform

expect val platformNetworkEngineModule: Module
package com.dino.newskmp.app.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by dinopriyano on 04/11/23.
 */

actual val ioDispatcher: CoroutineDispatcher
  get() = Dispatchers.IO
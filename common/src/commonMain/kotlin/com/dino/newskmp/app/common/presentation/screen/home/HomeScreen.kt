package com.dino.newskmp.app.common.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dino.newskmp.app.SharedRes
import dev.icerock.moko.resources.compose.stringResource
import org.koin.compose.koinInject

/**
 * Created by dinopriyano on 05/11/23.
 */
@Composable fun HomeScreen () {

  Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
    // Home header
    TopAppBar(
      modifier = Modifier.fillMaxWidth(),
      backgroundColor = MaterialTheme.colorScheme.background
    ) {
      Text(
        text = stringResource(SharedRes.strings.app_name),
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onBackground
      )
    }

    // Category
    LazyRow {

    }

    // Slider content
  }
}
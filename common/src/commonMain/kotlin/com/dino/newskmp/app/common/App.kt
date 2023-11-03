package com.dino.newskmp.app.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dino.newskmp.app.common.ui.theme.NewsKMPTheme

/**
 * Created by dinopriyano on 04/11/23.
 */

@Composable fun NewsApp() {
  NewsKMPTheme { // A surface container using the 'background' color from the theme
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
      Greeting("Android")
    }
  }
}

@Composable fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!", modifier = modifier
  )
}
package com.dino.newskmp.app.common.presentation.component

import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Created by dinopriyano on 11/11/23.
 */

@Composable fun RawrChip(
  title: String,
  isSelected: Boolean,
  modifier: Modifier,
  onClick: (String) -> Unit
) {
  Text(
    text = title,
    style = if (isSelected) MaterialTheme.typography.labelLarge else MaterialTheme.typography.bodyMedium,
    color = MaterialTheme.colorScheme.onBackground,
    modifier = modifier.selectable(
      selected = isSelected,
      onClick = {
        onClick(title)
      }
    )
  )
}
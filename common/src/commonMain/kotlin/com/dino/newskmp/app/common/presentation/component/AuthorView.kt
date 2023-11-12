package com.dino.newskmp.app.common.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dino.newskmp.app.SharedRes
import com.seiko.imageloader.rememberAsyncImagePainter
import dev.icerock.moko.resources.compose.stringResource

/**
 * Created by dinopriyano on 12/11/23.
 */

@Composable fun AuthorView(
  authorName: String,
  avatar: Painter,
  modifier: Modifier
) {
  Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Image(
      modifier = Modifier.size(36.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primary),
      contentScale = ContentScale.Crop,
      painter = avatar,
      contentDescription = null
    )
    Column(
      modifier = Modifier.weight(1f).padding(horizontal = 8.dp)
    ) {
      Text(
        text = stringResource(SharedRes.strings.published_by_txt),
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.secondary
      )
      Text(
        text = authorName,
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.primary,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(top = 4.dp)
      )
    }
    Button(
      colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground
      ),
      onClick = {}
    ) {
      Text(
        text = stringResource(SharedRes.strings.follow_txt),
        style = MaterialTheme.typography.bodyMedium
      )
    }
  }
}
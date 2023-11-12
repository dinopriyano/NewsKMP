package com.dino.newskmp.app.common.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dino.newskmp.app.SharedRes
import com.dino.newskmp.app.common.data.DummyData
import com.dino.newskmp.app.common.domain.model.News
import com.dino.newskmp.app.common.utils.formatToTimeAgo
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

/**
 * Created by dinopriyano on 12/11/23.
 */

@Composable fun NewsShortcut(
  news: News,
  modifier: Modifier
) {

  Column(modifier = modifier) {
    Text(
      text = news.title.orEmpty(),
      style = MaterialTheme.typography.titleLarge,
      color = MaterialTheme.colorScheme.primary,
      maxLines = 3,
      overflow = TextOverflow.Ellipsis
    )
    Text(
      text = "${stringResource(SharedRes.strings.updated_txt)} ${formatToTimeAgo(news.publishedAt.orEmpty())}",
      style = MaterialTheme.typography.bodySmall,
      color = MaterialTheme.colorScheme.secondary,
      modifier = Modifier.padding(top = 16.dp)
    )
    AuthorView(
      authorName = news.author.orEmpty(),
      avatar = painterResource(DummyData.getRandomAvatar()),
      modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
    )
    Text(
      text = news.description.orEmpty(),
      style = MaterialTheme.typography.bodyMedium,
      color = MaterialTheme.colorScheme.secondary,
      modifier = Modifier.padding(top = 24.dp)
    )
  }
}
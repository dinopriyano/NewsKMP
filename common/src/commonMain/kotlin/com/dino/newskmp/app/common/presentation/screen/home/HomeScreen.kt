package com.dino.newskmp.app.common.presentation.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import com.dino.newskmp.app.SharedRes
import com.dino.newskmp.app.common.data.DummyData
import com.dino.newskmp.app.common.presentation.base.BaseScreen
import com.dino.newskmp.app.common.presentation.component.NewsShortcut
import com.dino.newskmp.app.common.presentation.component.RawrChip
import com.dino.newskmp.app.common.presentation.theme.IconPastel
import com.dino.newskmp.app.common.presentation.theme.LowTransparent
import com.dino.newskmp.app.common.utils.carouselTransition
import com.dino.newskmp.app.common.utils.getCardColor
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

/**
 * Created by dinopriyano on 05/11/23.
 */

class HomeScreen: BaseScreen<HomeScreenModel, HomeScreenUiState, HomeScreenUiEffect, HomeScreenInteractionListener>() {

  @Composable
  override fun Content() {
    initScreen(getScreenModel())
  }

  @Composable
  override fun onRender(state: HomeScreenUiState, listener: HomeScreenInteractionListener) {
    var selectedCategoryIndex by rememberSaveable { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
      // Home header
      NewsHeader(Modifier.fillMaxWidth())

      // Category
      NewsCategories(
        selectedCategoryIndex,
        DummyData.categories,
        Modifier.padding(top = 16.dp),
      ) { title, index ->
        selectedCategoryIndex = index
      }

      // Slider content
      NewsSlider(modifier = Modifier.fillMaxSize().padding(bottom = (56.dp + 5.dp + 24.dp)))
    }
  }

  override fun onEffect(effect: HomeScreenUiEffect, navigator: Navigator) {
    // TODO: Not yet implemented
  }
}

@Composable fun NewsHeader(
  modifier: Modifier
) {
  TopAppBar(
    modifier = modifier,
    backgroundColor = MaterialTheme.colorScheme.background,
    elevation = 0.dp
  ) {
    Icon(
      painter = painterResource(SharedRes.images.ic_news_light),
      modifier = Modifier.padding(start = 24.dp).size(42.dp),
      tint = Color.Unspecified,
      contentDescription = null
    )
    Spacer(Modifier.width(8.dp))
    Text(
      text = stringResource(SharedRes.strings.title),
      style = MaterialTheme.typography.titleLarge,
      color = MaterialTheme.colorScheme.onBackground
    )
  }
}

@Composable fun NewsCategories(
  selectedCategoryIndex: Int = 0,
  categories: List<String>,
  modifier: Modifier,
  onSelected: (String, Int) -> Unit
) {
  LazyRow (
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(16.dp),
    verticalAlignment = Alignment.CenterVertically,
    contentPadding = PaddingValues(horizontal = 24.dp)
  ) {
    itemsIndexed(categories) { index, item ->
      RawrChip(
        item,
        index == selectedCategoryIndex,
        Modifier
      ) { title ->
        onSelected(title, index)
      }
    }
  }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class) @Composable fun NewsSlider(
  modifier: Modifier
) {
  val pagerState = rememberPagerState(
    pageCount = {
      DummyData.newsList.size
    }
  )
  HorizontalPager(
    state = pagerState,
    modifier = modifier,
    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp)
  ) { page ->
    val news = DummyData.newsList.getOrNull(page)
    news?.let { news ->
      Card(
        onClick = {  },
        modifier = Modifier
          .carouselTransition(
            page,
            pagerState
          ),
        shape = RoundedCornerShape(28.dp),
        elevation = CardDefaults.cardElevation(16.dp),
        colors = CardDefaults.cardColors(
          containerColor = getCardColor(page)
        )
      ) {
        Column(
          modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.End
        ) {
          NewsShortcut(
            news = news,
            modifier = Modifier.fillMaxWidth().weight(1f).padding(24.dp)
          )
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.padding(16.dp)
          ) {
            ActionImage(
              imageResource = SharedRes.images.ic_like_outlined,
              modifier = Modifier
            ) {

            }
            ActionImage(
              imageResource = SharedRes.images.bookmark_outlined,
              modifier = Modifier
            ) {

            }
            ActionImage(
              imageResource = SharedRes.images.ic_share_outlined,
              modifier = Modifier
            ) {

            }
          }
        }
      }
    }
  }
}

@Composable fun ActionImage(
  imageResource: ImageResource,
  modifier: Modifier,
  onClick: () -> Unit
) {
  IconButton(
    modifier = modifier.clip(CircleShape).background(LowTransparent),
    onClick = onClick
  ) {
    Icon(
      painterResource(imageResource),
      contentDescription = null,
      modifier = Modifier.padding(5.dp),
      tint = IconPastel
    )
  }
}


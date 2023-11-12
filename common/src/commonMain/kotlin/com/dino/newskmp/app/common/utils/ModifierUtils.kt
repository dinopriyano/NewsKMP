package com.dino.newskmp.app.common.utils

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.zIndex
import kotlin.math.absoluteValue

/**
 * Created by dinopriyano on 12/11/23.
 */

@OptIn(ExperimentalFoundationApi::class) fun Modifier.carouselTransition(
  page: Int,
  pagerState: PagerState
) = composed {
  val isLastPage = page == pagerState.pageCount - 1
  val pageOffset =
    ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction)
  val absPageOffset = pageOffset.absoluteValue

  graphicsLayer {

    // Scale item
    scaleY = MathUtils.lerp(
      start = 0.9f,
      stop = 1f,
      fraction = 1f - absPageOffset.coerceIn(0f, 1f)
    )

    // Rotate item
    val maxRotationDegree = 10f
    val rotationDegree = if (isLastPage && pagerState.currentPage == pagerState.pageCount - 1) {
      0f
    } else {
      maxRotationDegree * (if (pageOffset > 0) -1 else 1) * absPageOffset.coerceIn(0f, 1f)
    }
    rotationZ = rotationDegree

    // Translation
    translationX = pageOffset * (size.width / 1.2F)
    translationY = (if (pageOffset > 0) 1 else -1) * (pageOffset * ((MathUtils.calculateRotatedHeight(size.width, size.height, rotationDegree) - size.height) / 2))

  }.zIndex(1f - absPageOffset)
}

@OptIn(ExperimentalFoundationApi::class) fun calculatePageOffset(page: Int, pagerState: PagerState): Float {
  val offset = pagerState.currentPageOffsetFraction
  return if (pagerState.currentPage > page) {
    offset - (pagerState.currentPage - page)
  } else {
    (page - pagerState.currentPage) - offset
  }
}
package com.dino.newskmp.app.common.platform

/**
 * Created by dinopriyano on 12/11/23.
 */
expect class DateTime() {

  fun getFormattedDate(
    iso8601Timestamp: String,
    format: String,
  ): String
}
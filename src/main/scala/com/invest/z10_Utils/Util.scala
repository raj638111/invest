package com.invest.z10_Utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Util {

  def localDateTime(tStamp: Option[String]): Option[LocalDateTime] = {
    tStamp.map{ tStamp =>
      val formatter = DateTimeFormatter.ISO_DATE_TIME
      LocalDateTime.parse(tStamp, formatter)
    }
  }

}

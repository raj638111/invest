package com.invest.a30_Data

import io.circe.{Json, yaml}

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.io.Source

case class Txn(
                tStamp: Option[String] = None,
                transactionType: Option[String] = None,
                asset: Option[String] = None,
                quantityTransacted: Option[Double] = None,
                spotPriceCurrency: Option[String] = None,
                sportPriceCurrencyAtTransaction: Option[Double] = None,
                total: Option[Double] = None,
                exchange: Option[String] = None) {

  override def toString() = {
    s"tStamp = $tStamp, transactionType = $transactionType, asset = $asset, " +
      s"quantityTransacted = $quantityTransacted, spotPriceCurrency = $spotPriceCurrency, " +
      s"sportPriceCurrencyAtTransaction = $sportPriceCurrencyAtTransaction, " +
      s"total = $total, exchange = ${exchange}"
  }

  def localDateTime(): Option[LocalDateTime] = {
    tStamp.map{ tStamp =>
      val formatter = DateTimeFormatter.ISO_DATE_TIME
      LocalDateTime.parse(tStamp, formatter)
    }
  }


}
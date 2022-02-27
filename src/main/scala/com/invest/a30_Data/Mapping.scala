package com.invest.a30_Data

import io.circe.{Decoder, HCursor, Json, yaml}
import com.invest.a30_Data.{Mapping, Txn}
import com.invest.z10_Utils.Util
import io.circe._
import io.circe.generic.auto._
import io.circe.generic.semiauto._

import java.time.LocalDateTime
import scala.io.Source

/*
- asset: bitcoin
  sellTStamp: 2020-12-24T16:16:34Z
  buyTStamps:
    - 2020-12-16T05:34:26Z
    - 2020-12-16T15:05:52Z
    - 2020-12-16T15:07:21Z
    - 2020-12-16T15:14:25Z
    - 2020-12-17T21:00:30Z

 */
case class Mapping(
                     asset: Option[String] = None,
                     sellTStamp: Option[LocalDateTime] = None
                   ) {

  def loadString(content: String): List[Mapping] = {
    implicit val decodeMapping = new Decoder[Mapping] {
      def apply(c: HCursor): Decoder.Result[Mapping] =
        for {
          asset <- c.downField("asset").as[Option[String]]
          sellTStamp <- c.downField("sellTStamp").as[Option[String]]
        } yield {
          println("Yield")
          new Mapping(asset, Util.localDateTime(sellTStamp))
        }
    }
    yaml.parser.parse(content) match {
      case Left(failure) => throw new Exception(failure.message)
      case Right(json: Json) =>
        json.as[List[Mapping]].map(x => x) match {
          case Left(failure) => throw new Exception(failure.message)
          case Right(mapping: List[Mapping]) => mapping
        }
    }
  }

  /*def loadString(content: String): List[Mapping] = {
    yaml.parser.parse(content) match {
      case Left(failure) => throw new Exception(failure.message)
      case Right(json: Json) =>
        json.as[List[Mapping]].map(x => x) match {
          case Left(failure) => throw new Exception(failure.message)
          case Right(txn: List[Mapping]) => txn
        }
    }
  }*/

  def loadFile(fileName: String): List[Mapping] = {
    val fileContent = Source.fromFile(fileName).getLines().toList.mkString("\n")
    loadString(fileContent)
  }

  override def toString = {
    s"asset = $asset, sellTStamp = ${sellTStamp}"
  }


}



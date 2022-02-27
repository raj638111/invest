package com.invest.a20_Calculators

import com.invest.a30_Data.{Mapping, Txn}
import io.circe._
import io.circe.generic.auto._
import io.circe.generic.semiauto._

import java.time.format.DateTimeFormatter
import scala.io.Source

object FileReader {

  def filterTxn(txns: List[Txn],
                assets: Set[String] = Set.empty,
                txnTypes: Set[String] = Set.empty): List[Txn] = {
    txns
      .filter{txn => if(assets.isEmpty) true else assets.contains(txn.asset.get)}
      .filter{txn => if(txnTypes.isEmpty) true else txnTypes.contains(txn.transactionType.get)}
  }

//  def convertYamlStringCaseClass(yamlString: String): Txn = {
//    val decoder = deriveDecoder[Txn]
//    yaml
//      .parser
//      .parse(yamlString) match {
//      case Left(failure) => throw new Exception(failure.message)
//      case Right(json: Json) =>
//        decoder.decodeJson(json).map(x => x) match {
//          case Left(failure) => throw new Exception(failure.message)
//          case Right(txn: Txn) => txn
//        }
//    }
//  }

  def loadTransactions(fileName: String): List[Txn] = {
    val fileContent = Source.fromFile(fileName).getLines().toList.mkString("\n")
    yaml.parser.parse(fileContent) match {
      case Left(failure) => throw new Exception(failure.message)
      case Right(json: Json) =>
        json.as[List[Txn]].map(x => x) match {
          case Left(failure) => throw new Exception(failure.message)
          case Right(txn: List[Txn]) => txn
        }
    }
  }



}


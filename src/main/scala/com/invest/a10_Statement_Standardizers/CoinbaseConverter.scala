package com.invest.a10_Statement_Standardizers

import java.nio.file.{Files, Paths}
import scala.io.Source

object CoinbaseConverter {

  def convertStatementFileToYamlFile(statementFile: String, yamlFile: String): Unit = {
    val yamlRecords = convertStatementFileToYamlRecords(statementFile)
    yamlRecords.foreach(println _)
    Files.write(Paths.get(yamlFile), yamlRecords.mkString("\n").getBytes)
  }

  def convertStatementFileToYamlRecords(statementFile: String): List[String] = {
    val heading :: rest = Source.fromFile(statementFile).getLines().toList
    rest.map(splitter(_))
  }

  def splitter(line: String): String = {
    /*
    0 - Timestamp,
    1 - Transaction Type,
    2 - Asset,
    3 - Quantity Transacted,
    4 - Spot Price Currency,
    5 - Spot Price at Transaction,
    6 - Subtotal,
    7 - Total (inclusive of fees),
    8 - Fees,
    9 - Notes
    2020-12-16T05:34:26Z,Buy,BTC,0.00497205,USD,19511.07,97.01,100.00,2.99,Bought 0.00497205 BTC for $100.00 USD
    */
    val fields = line.split("[,]")
    val tStamp = fields(0)
    val transactionType = fields(1)
    val asset = fields(2)
    val quantityTransacted = fields(3)
    val spotPriceCurrency = fields(4)
    val sportPriceCurrencyAtTransaction = fields(5)
    val total = fields(7)
    s"""
       |- tStamp: "$tStamp"
       |  transactionType: ${transactionType.toLowerCase}
       |  asset: ${asset.toLowerCase}
       |  quantityTransacted: $quantityTransacted
       |  spotPriceCurrency: ${spotPriceCurrency.toLowerCase}
       |  sportPriceCurrencyAtTransaction: $sportPriceCurrencyAtTransaction
       |  total: ${total.replace("\"", "")}
       |  exchange: coinbase
       |""".stripMargin

  }

}

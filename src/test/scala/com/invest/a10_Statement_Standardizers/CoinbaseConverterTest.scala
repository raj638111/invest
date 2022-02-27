package com.invest.a10_Statement_Standardizers

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should


class CoinbaseConverterTest extends AnyFunSuiteLike with should.Matchers {

  val home = System.getProperty("user.home")
  println(s"home = $home")

  val statement = s"$home/ws/tax-statements/a10_Original_statements/a10_Coinbase-2021_12_16_to_2022_02_04.csv"
  val yamlFile = s"$home/ws/tax-statements/a10_yamled/a10_Coinbase-2021_12_16_to_2022_02_04.yaml"

  test("splitter()"){
    //val line = "2020-12-16T05:34:26Z,Buy,BTC,0.00497205,USD,19511.07,97.01,100.00,2.99,Bought 0.00497205 BTC for $100.00 USD"
    val line = "2021-08-23T21:38:03Z,Receive,ADA,13.0,USD,2.93,\"\",\"\",\"\",Received 13.0000 ADA from an external account"
    val formatted = CoinbaseConverter.splitter(line)
    println(formatted)
  }

  test("convertToYaml()"){
    val res = CoinbaseConverter.convertStatementFileToYamlRecords(statement)
    res.take(5).foreach(println _)
  }

  test("convertStatementToYaml()"){
    CoinbaseConverter.convertStatementFileToYamlFile(statement, yamlFile)
  }


}

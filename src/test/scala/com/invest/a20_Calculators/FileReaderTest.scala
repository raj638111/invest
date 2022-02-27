//package com.invest.a20_Calculators
//
//import com.invest.a30_Data.Txn
//import org.scalatest.funsuite.AnyFunSuiteLike
//import org.scalatest.matchers.should
//
//class FileReaderTest extends AnyFunSuiteLike with should.Matchers {
//
//  val home = System.getProperty("user.home")
////  test("convertYamlStringToJson()"){
////    val str =
////      """
////        |tStamp: "2020-12-16T05:34:26Z"
////        |transactionType: Buy
////        |asset: BTC
////        |quantityTransacted: 0.00497205
////        |spotPriceCurrency: USD
////        |sportPriceCurrencyAtTransaction: 19511.07
////        |total: 100.00
////        |""".stripMargin
////    val res = Calculator.convertYamlStringCaseClass(str)
////    println(s"res => $res")
////  }
//
//  def _loadTransaction(): List[Txn] = {
//    val yamlFile = s"${home}/ws/tax-statements/a10_yamled/a10_Coinbase-2021_12_16_to_2022_02_04.yaml"
//    FileReader.loadTransactions(yamlFile)
//  }
//
//  test("convertYamlFileToCaseClass()"){
//    val res = _loadTransaction()
//    res.foreach(println _)
//  }
//
//  def _filterTxn(asset: String): Unit = {
//    val txns = _loadTransaction()
//    val filtered = FileReader.filterTxn(txns, assets = Set(asset), txnTypes = Set("buy", "sell"))
//    filtered.foreach(println _)
//    val bought = filtered.filter(_.transactionType.get == "buy").map(_.quantityTransacted.get).reduce(_ + _)
//    println(s"Total $asset bought = $bought")
//    val sold = filtered.filter(_.transactionType.get == "sell").map(_.quantityTransacted.get).reduce(_ + _)
//    println(s"Total $asset sold = $sold")
//  }
//
//  test("filterTxn(): btc"){
//    _filterTxn("btc")
//  }
//
//  test("filterTxn(): eth"){
//    _filterTxn("eth")
//  }
//
//  test("filterTxn(): ada"){
//    _filterTxn("ada")
//  }
//
//
//  test("loadMappings()"){
//    val yamlFile = s"${home}/ws/tax-statements/a20_Sell_to_Buy_Mappings/a10_Bitcoin.yaml"
//    val res = FileReader.loadMappings(yamlFile)
//    res.foreach(mapping => println(s"mapping = $mapping"))
//  }
//
//}

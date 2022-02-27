package com.invest.a30_Data

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should

class TxnTest extends AnyFunSuiteLike with should.Matchers {

  test("dTime()"){
    val txn = Txn(tStamp = Some("2020-12-17T21:00:30Z"))
    println(s"tStamp = ${txn.tStamp}, localDateTime = ${txn.localDateTime}")
    txn.tStamp.get.dropRight(1) should be (txn.localDateTime.get.toString)
  }


}

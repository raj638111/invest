package com.invest.a30_Data

import org.scalatest.FunSuite
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should

class MappingTest extends AnyFunSuiteLike with should.Matchers {

  test("test()"){
    val content =
      """
        |- asset: bitcoin
        |  sellTStamp: 2020-12-24T16:16:34Z
        |
        |- asset: eth
        |  sellTStamp: 2020-12-24T16:16:34Z
        |
        |""".stripMargin
    val res = Mapping().loadString(content)
    res.foreach(println _)
  }

}

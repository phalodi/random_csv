package org.sandeep.csv.utils

import org.joda.time.DateTime
import org.scalatest.FunSuite

class CSVUtilsSpec extends FunSuite with CSVUtils {

  import org.joda.time.format.DateTimeFormat
  import org.joda.time.format.DateTimeFormatter

  val formatter: DateTimeFormatter = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss")

  test("A generateProducts should have n number of products") {
    assert(generateProducts(5).size == 5)
  }

  test("A random date generator should return DateTime object") {
    assert(formatter.parseDateTime(randomDateTime).getClass == classOf[DateTime])
  }

  test("A getHeader should return header for csv") {
    assert(getHeader == List(List("ID", "DATE", "PRODUCT", "PRICE", "QUANTITY")))
  }

}

package org.sandeep.csv.utils

import java.nio.charset.StandardCharsets
import java.sql.Timestamp
import java.text.DecimalFormat
import java.util.UUID

import com.github.tototoshi.csv.DefaultCSVFormat
import org.apache.commons.lang3.RandomStringUtils
import org.joda.time.DateTime

import scala.util.Random

trait CSVUtils {

  val random = new Random()

  def getHeader = List(List("ID", "DATE", "PRODUCT", "PRICE", "QUANTITY"))

  def randomDateTime = {
    val pattern = "yyyy/MM/dd HH:mm:ss"
    val d1 = Timestamp.valueOf("2013-02-08 00:00:00").getTime
    val d2 = Timestamp.valueOf("2019-02-08 11:59:59").getTime
    new DateTime(d1 + (random.nextDouble * (d2 - d1)).toLong).toString(pattern)
  }

  implicit object MyFormat extends DefaultCSVFormat {
    override val delimiter = ';'
  }

  implicit class Encoder(s:String) {
    def encodeUTF8 = new String(s.getBytes(StandardCharsets.UTF_8))
  }

  def generateProducts(noOfRows: Int) = {
    (1 to noOfRows).map(_ =>
      List(UUID.randomUUID.toString.encodeUTF8, randomDateTime.encodeUTF8,
        RandomStringUtils.randomAlphabetic(20 + random.nextInt(20 - 15) + 1).toLowerCase().encodeUTF8,
        new DecimalFormat("0.00").format(random.nextFloat * 10000).encodeUTF8, random.nextInt(5000).toString.encodeUTF8))
  }
}

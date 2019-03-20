package org.sandeep.csv

import java.io.FileWriter

import com.github.tototoshi.csv.{CSVWriter, DefaultCSVFormat}
import org.sandeep.csv.utils.CSVUtils

import scala.util.Try


object CSVGenerator extends DefaultCSVFormat with CSVUtils {
  def main(args: Array[String]) {

    Try(randomCSVWriter(args.head, args.last.toInt)).getOrElse(randomCSVWriter("./test.csv",10))

    def randomCSVWriter(filePath: String, noOfRows: Int) = {
      val out = new FileWriter(filePath)
      val writer = CSVWriter.open(out)
      val productAll = getHeader ++ generateProducts(noOfRows)
      writer.writeAll(productAll)
      out.close()
    }
  }
}

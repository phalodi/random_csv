package org.sandeep.csv

import org.scalatest.WordSpec

class CSVGeneratorITSpec extends WordSpec {

  "A CSV generator generate" should  {
    "generate CSV in file path" in {
      CSVGenerator.main(Array("./test.csv","10"))
      assert(new java.io.File("./test.csv").exists)
    }
  }
}
### How to run application locally

* First go to project directory `/random_csv`
* Run the following commands

  > sbt
  > run ./test1.csv 20

Note: If not provide file name and number of rows in arguments then it will create csv on default file `./test.csv` with 10 rows

### Run unit test
   > sbt test

### Run integration test

   > sbt it:test
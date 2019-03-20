
lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(
    name := "random_csv",
    version := "1.0.0",
    scalaVersion := "2.12.6",
    Defaults.itSettings,
    libraryDependencies ++= Seq("com.github.tototoshi" %% "scala-csv" % "1.3.5",
      "org.apache.commons" % "commons-lang3" % "3.8.1",
      "joda-time" % "joda-time" % "2.10.1",
      "org.scalatest" %% "scalatest" % "3.0.6" % "test,it"
    ),
    dockerImageCreationTask := (publishLocal in Docker).value
  ).enablePlugins(JavaAppPackaging, DockerComposePlugin)


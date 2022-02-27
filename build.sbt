name := "invest"

scalaVersion := "2.12.10"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-yaml" % "0.14.1",
  "io.circe" %% "circe-core" % "0.14.1",
  "io.circe" %% "circe-generic" % "0.14.1",
  "io.circe" %% "circe-parser" % "0.14.1",
  "io.circe" %% "circe-optics" % "0.14.1",
  "org.scalatest" %% "scalatest" % "3.1.0" % Test
)
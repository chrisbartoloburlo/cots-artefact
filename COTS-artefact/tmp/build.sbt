name := "petclinic"

version := "1.0"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.client3" %% "core" % "3.3.18",
  "com.softwaremill.sttp.client3" %% "json4s" % "3.3.18",
  "org.json4s" %% "json4s-jackson" % "4.0.4",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.3",
  "com.github.tototoshi" %% "scala-csv" % "1.3.6"
)

assemblyMergeStrategy in assembly := {
  case PathList("jackson-annotations-2.12.6.jar", xs @ _*) => MergeStrategy.rename
  case PathList("jackson-core-2.12.6.jar", xs @ _*) => MergeStrategy.rename
  case PathList("jackson-databind-2.12.6.jar", xs @ _*) => MergeStrategy.rename
  case PathList("jackson-dataformat-cbor-2.10.3.jar", xs @ _*) => MergeStrategy.last
  case PathList("jackson-datatype-jdk8-2.10.3.jar", xs @ _*) => MergeStrategy.last
  case PathList("jackson-datatype-jsr310-2.10.3.jar", xs @ _*) => MergeStrategy.last
  case PathList("jackson-module-parameter-names-2.10.3.jar", xs @ _*) => MergeStrategy.last
  case PathList("jackson-module-paranamer-2.10.3.jar", xs @ _*) => MergeStrategy.last
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

version := "0.0.3"

scalaVersion := "2.13.5"

scalacOptions ++= Seq(
  "-unchecked", "-feature"
)
// ScalaDoc setup
autoAPIMappings := true

Compile / doc / scalacOptions ++= Seq(
  "-no-link-warnings" // Workaround for ScalaDoc @throws links issues
)

// for debugging sbt problems
logLevel := Level.Debug

scalacOptions += "-deprecation"

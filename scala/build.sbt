name := """sora_api_client_scala_sample"""

version := "0.1"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.4.2",
  "org.slf4j" % "slf4j-simple" % "1.7.12",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"
)

EclipseKeys.createSrc := "src/main"
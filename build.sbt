name := """play-scala-hashids"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

resolvers += "dl-john-ky" at "http://dl.john-ky.io/maven/releases"

libraryDependencies += "io.john-ky" %% "hashids-scala" % "1.1.2-2974446"

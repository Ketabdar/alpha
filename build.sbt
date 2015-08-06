name := """a2pi"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "com.datastax.cassandra" % "cassandra-driver-core" % "2.2.0-rc2",
  specs2 % Test

)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"


//resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

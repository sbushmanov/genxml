
scalaVersion := "2.13.8"
name := "hello-world"
organization := "ch.epfl.scala"
version := "1.0"

libraryDependencies ++= Seq(
    "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1",
    "javax.xml.bind" % "jaxb-api" % "2.3.1"
)

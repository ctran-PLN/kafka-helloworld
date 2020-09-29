name := "kafka-producer-scala"

version := "0.1"

scalaVersion := "2.11.12"

assemblyJarName in assembly := "init-scala-consumer"

libraryDependencies += "com.typesafe" % "config" % "1.3.2"
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "1.0.0"

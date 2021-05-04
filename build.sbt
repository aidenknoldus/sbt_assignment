name := "aiden_sbt_assignment"

version := "0.1"

scalaVersion := "2.12.12"

lazy val common = project.in(file("common"))
  .settings(
    libraryDependencies ++= Seq (
      "org.json4s" %% "json4s-native" % "3.7.0-M16",
      "org.slf4j" % "slf4j-log4j12" % "1.2",
      "com.typesafe" % "config" % "1.2.1",
      "org.scalatest" %% "scalatest" % "3.2.7" % Test,
      "org.mockito" %% "mockito-scala" % "1.5.12" % Test
    )
  )

lazy val persistence = project.in(file("persistence"))
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.slick" %% "slick" % "3.3.3",
      "org.postgresql" % "postgresql" % "42.1.1",
      "com.h2database" % "h2" % "1.3.148" % Test
    )
  )
  .dependsOn(common)

addSbtPlugin("io.github.knoldus" % "codesquad-sbt-plugin" % "0.2.1")
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")

lazy val root = project.in(file(".")).aggregate(common,  persistence)
import sbt._
import sbt.Keys._
import com.typesafe.sbtscalariform.ScalariformPlugin._

object Build extends Build {

  lazy val root = Project(
    "scalalogging",
    file("."),
    settings = commonSettings ++ Seq(
      libraryDependencies ++= Seq(
        Dependencies.config,
        Dependencies.scalaz
      )
    )
  )

  def commonSettings = 
    Defaults.defaultSettings ++ 
    Seq(
      organization := "name.heikoseeberger.scalalogging",
      scalacOptions ++= Seq("-unchecked", "-deprecation"),
      libraryDependencies ++= Seq(
        Dependencies.specs2,
        Dependencies.scalacheck,
        Dependencies.mockito,
        Dependencies.hamcrest
      ),
      initialCommands in console := "import name.heikoseeberger.scalalogging._"
    ) ++
    scalariformSettings

  object Dependencies {
    // Compile
    val config = "com.typesafe" % "config" % "0.4.0"
    val scalaz = "org.scalaz" %% "scalaz-core" % "6.0.4"
    // Test
    val specs2 = "org.specs2" %% "specs2" % "1.9" % "test"
    val scalacheck = "org.scalacheck" %% "scalacheck" % "1.9" % "test"
    val mockito = "org.mockito" % "mockito-all" % "1.9.0" % "test"
    val hamcrest = "org.hamcrest" % "hamcrest-all" % "1.1" % "test"
  }
}

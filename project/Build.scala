import sbt._
import sbt.Keys._
import com.typesafe.sbtscalariform.ScalariformPlugin._

object Build extends Build {

  lazy val root = Project(
    "scalalogging",
    file("."),
    settings = commonSettings ++ Seq(
/*      libraryDependencies ++= Seq(
        Dependencies.config,
        Dependencies.scalaz
      )*/
    )
  )

  def commonSettings = 
    Defaults.defaultSettings ++ 
    Seq(
      resolvers += Opts.resolver.sonatypeSnapshots,
      organization := "name.heikoseeberger.scalalogging",
      scalaVersion := "2.10.0-SNAPSHOT",
      scalacOptions ++= Seq("-unchecked", "-deprecation", "-optimize"),
/*      libraryDependencies ++= Seq(
        Dependencies.specs2,
        Dependencies.scalacheck,
        Dependencies.mockito,
        Dependencies.hamcrest
      ),*/
      initialCommands in console := "import name.heikoseeberger.scalalogging._"
    ) ++
    scalariformSettings

  object Dependencies {
    // Compile
    // Test
//    val specs2 = "org.specs2" %% "specs2" % "1.9" % "test"
//    val scalacheck = "org.scalacheck" %% "scalacheck" % "1.9" % "test"
//    val mockito = "org.mockito" % "mockito-all" % "1.9.0" % "test"
//    val hamcrest = "org.hamcrest" % "hamcrest-all" % "1.1" % "test"
  }
}

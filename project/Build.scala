import com.typesafe.sbtscalariform.ScalariformPlugin._
import sbt._
import sbt.Keys._
import sbtrelease.ReleasePlugin._

object Build extends Build {

  val ScalaVersion = "2.10.0-M6"

  lazy val root = Project(
    "root",
    file("."),
    settings = commonSettings ++ Seq(
      publishArtifact := false
    ),
    aggregate = Seq(scalalogging, scalaloggingTest)
  )

  lazy val scalalogging = Project(
    "scalalogging",
    file("scalalogging"),
    settings = commonSettings ++ Seq(
      libraryDependencies := Seq(
        Dependencies.Compile.ScalaReflect,
        Dependencies.Compile.Slf4j
      )
    )
  )

  lazy val scalaloggingTest = Project(
    "scalalogging-test",
    file("scalalogging-test"),
    settings = commonSettings ++ Seq(
      publishArtifact := false
    ),
    dependencies = Seq(scalalogging)
  )

  def commonSettings = Defaults.defaultSettings ++ 
    scalariformSettings ++
    releaseSettings ++
    Seq(
      organization := "name.heikoseeberger",
      scalaVersion := ScalaVersion,
      scalacOptions ++= Seq("-unchecked", "-deprecation", "-optimize", "-target:jvm-1.6"),
      libraryDependencies ++= Seq(
        Dependencies.Test.Specs2,
        Dependencies.Test.Mockito,
        Dependencies.Test.Hamcrest
      ),
      licenses := Seq("Apache 2.0 License" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")),
      homepage := Some(url("https://github.com/hseeberger/scalalogging")),
      publishTo <<= isSnapshot(isSnapshot => Some(if (isSnapshot) Opts.resolver.sonatypeSnapshots else Opts.resolver.sonatypeStaging)),
      publishArtifact in Test := false,
      pomIncludeRepository := (_ => false),
      pomExtra :=
        <scm>
          <url>https://github.com/hseeberger/scalalogging</url>
          <connection>scm:git:git://github.com/hseeberger/scalalogging.git</connection>
        </scm>
        <developers>
          <developer>
            <id>hseeberger</id>
            <name>Heiko Seeberger</name>
            <url>http://heikoseeberger.name</url>
          </developer>
        </developers>,
      initialCommands in console := "import name.heikoseeberger.scalalogging._"
    )

  object Dependencies {

    object Compile {
      val ScalaReflect = "org.scala-lang" % "scala-reflect" % ScalaVersion
      val Slf4j = "org.slf4j" % "slf4j-api" % "1.6.6"
    }

    object Test {
      val Specs2 = "org.specs2" %% "specs2" % "1.11" % "test" cross CrossVersion.full
//      val ScalaCheck = "org.scalacheck" %% "scalacheck" % "1.9" % "test"
      val Mockito = "org.mockito" % "mockito-all" % "1.9.0" % "test"
      val Hamcrest = "org.hamcrest" % "hamcrest-all" % "1.1" % "test"
    }
  }
}

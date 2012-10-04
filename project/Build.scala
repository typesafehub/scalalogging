import sbt._
import sbt.Keys._
import com.typesafe.sbt.SbtScalariform._
import sbtrelease.ReleasePlugin._

object Build extends Build {

  val ScalaVersion = "2.10.0-M7"

  lazy val root = Project(
    "scalalogging",
    file("."),
    settings = commonSettings ++ Seq(
      publishArtifact := false
    ),
    aggregate = Seq(
      scalaloggingSlf4j,
      scalaloggingSlf4jTest,
      scalaloggingLog4j,
      scalaloggingLog4jTest
    )
  )

  lazy val scalaloggingSlf4j = Project(
    "scalalogging-slf4j",
    file("scalalogging-slf4j"),
    settings = commonSettings ++ Seq(
      libraryDependencies := Seq(
        Dependencies.Compile.ScalaReflect,
        Dependencies.Compile.Slf4jApi
      )
    )
  )

  lazy val scalaloggingSlf4jTest = Project(
    "scalalogging-slf4j-test",
    file("scalalogging-slf4j-test"),
    settings = commonSettings ++ Seq(
      publishArtifact := false
    ),
    dependencies = Seq(scalaloggingSlf4j)
  )

  lazy val scalaloggingLog4j = Project(
    "scalalogging-log4j",
    file("scalalogging-log4j"),
    settings = commonSettings ++ Seq(
      libraryDependencies := Seq(
        Dependencies.Compile.ScalaReflect,
        Dependencies.Compile.Log4jApi
      )
    )
  )

  lazy val scalaloggingLog4jTest = Project(
    "scalalogging-log4j-test",
    file("scalalogging-log4j-test"),
    settings = commonSettings ++ Seq(
      publishArtifact := false
    ),
    dependencies = Seq(scalaloggingLog4j)
  )

  def commonSettings = Defaults.defaultSettings ++ 
    scalariformSettings ++
    releaseSettings ++
    Seq(
      crossVersion := CrossVersion.full, // TODO Remove as soon as on Scala 2.10.0 final
      organization := "com.typesafe",
      scalaVersion := ScalaVersion,
      scalacOptions ++= Seq("-unchecked", "-deprecation", "-optimize", "-target:jvm-1.6"),
      libraryDependencies ++= Seq(
        Dependencies.Test.Specs2,
        Dependencies.Test.ScalaCheck,
        Dependencies.Test.Mockito,
        Dependencies.Test.Hamcrest
      ),
      licenses := Seq("Apache 2.0 License" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")),
      homepage := Some(url("https://github.com/typesafehub/scalalogging")),
      publishTo <<= isSnapshot(isSnapshot => Some(if (isSnapshot) Opts.resolver.sonatypeSnapshots else Opts.resolver.sonatypeStaging)),
      publishArtifact in Test := false,
      pomIncludeRepository := (_ => false),
      pomExtra :=
        <scm>
          <url>https://github.com/typesafehub/scalalogging</url>
          <connection>scm:git:git://github.com/typesafehub/scalalogging.git</connection>
        </scm>
        <developers>
          <developer>
            <id>hseeberger</id>
            <name>Heiko Seeberger</name>
            <url>http://heikoseeberger.name</url>
          </developer>
        </developers>,
      initialCommands in console := "import com.typesafe.scalalogging._"
    )

  object Dependencies {

    object Compile {
      val ScalaReflect = "org.scala-lang" % "scala-reflect" % ScalaVersion
      val Slf4jApi = "org.slf4j" % "slf4j-api" % "1.6.6"
      val Log4jApi = "org.apache.logging.log4j" % "log4j-api" % "2.0-beta1"
    }

    object Test {
      val Specs2 = "org.specs2" %% "specs2" % "1.12.1.1" % "test" cross CrossVersion.full
      val ScalaCheck = "org.scalacheck" %% "scalacheck" % "1.10.0" % "test" cross CrossVersion.full
      val Mockito = "org.mockito" % "mockito-all" % "1.9.0" % "test"
      val Hamcrest = "org.hamcrest" % "hamcrest-all" % "1.1" % "test"
    }
  }
}

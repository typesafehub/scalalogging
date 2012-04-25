
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)

addSbtPlugin("com.typesafe.sbtscalariform" % "sbtscalariform" % "0.3.1", sbtVersion = "0.12.0-Beta2")

addSbtPlugin("com.jsuereth" % "xsbt-gpg-plugin" % "0.6", sbtVersion = "0.12.0-Beta2")

ScalaLogging
============

Scala logging library wrapping <a href="http://www.slf4j.org/">SLF4J</a> in a convenient and performant fashion.

**Important change**: From version 0.2.0-SNAPSHOT on ScalaLogging is published under the group id `com.typesafe`. Also, the artifact id has changed to `scalalogging-slf4j`.

In principle the call of log messages should be avoided if the given log level is not enabled. Hence we should write the following code to log at the `debug` level:

    if (logger.isDebugEnabled) logger.debug(s"Some ${expensiveExpression} message!")

This is even true in the presence of parameterized log methods like available for <a href="http://logback.qos.ch">Logback</a>, at least if readability matters:

    if (logger.isDebugEnabled) logger.debug("Some {} message!", expensiveExpression)

Yet this idiom is too heavyweight, so that many of us just omit the `isEnabled`-check. Fortunately <a href="http://scalamacros.org/">Scala macros</a> can be used to make our lives easier: ScalaLogging offers the class `Logger` with lightweight logging methods that will be expanded to the above idiom. So all we have to write is:

    logger.debug(s"Some ${expensiveExpression} message!")

After the macro has been applied, the code will have been transformed into the above described idiom.

In addition ScalaLogging offers the trait `Logging` which conveniently provides a `Logger` instance initialized with the name of the class mixed into:

    class MyClass extends Logging {
      logger.debug("This is very convenient ;-)")
    }


Prerequisites
-------------

* Scala 2.10.0-M6
* SLF4J 1.6.6


Using ScalaLogging
------------------

ScalaLogging is published to the Sonatype OSS snapshot and release repositories. As the Sonatype OSS release repository is mirrored to Maven Central, you can use releases without adding custom resolvers to your sbt build definition or custom repositories to your Maven POM. The group id (organization) is `com.typesafe` and the artifact id (name) is `scalalogging-slf4j`.

<!--The following example shows how to add a dependency to the latest **release** version of ScalaLogging to your sbt (0.12.0 or later) build definition::

  libraryDependencies += "name.heikoseeberger" %% "scalalogging" % "0.1.0" cross CrossVersion.full
-->
The following example shows how to add a dependency to the latest **snapshot** version of ScalaLogging to your sbt (0.12.0 or later) build definition:

    resolvers += Opts.resolver.sonatypeSnapshots

    libraryDependencies += "com.typesafe" %% "scalalogging-slf4j" % "0.2.0-SNAPSHOT" cross CrossVersion.full


Contribution policy
-------------------

Contributions via GitHub pull requests are gladly accepted from their original author. Along with any pull requests, please state that the contribution is your original work and that you license the work to the project under the project's open source license. Whether or not you state this explicitly, by submitting any copyrighted material via pull request, email, or other means you agree to license the material under the project's open source license and warrant that you have the legal authority to do so.


License
-------

This code is open source software licensed under the <a href="http://www.apache.org/licenses/LICENSE-2.0.html">Apache 2.0 License</a>.

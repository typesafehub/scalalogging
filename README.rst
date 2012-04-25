ScalaLogging
============

Scala logging library wrapping the Java logging facility. If you want to use it together with SLF4J or Logback, just use the `JUL to SLF4J bridge`_.

In principle the evaluation of log messages should be avoided if the given log level is not enabled. Hence we should write the following code to log at the *INFO* level::

  if (logger.isLoggable(Level.INFO)) logger.info("Some %s message!".format("expensive"))

Yet this idiom is too heavyweight, so that many of us just omit the "loggable check", which in turn could lead to performance issues. Fortunately `Scala macros` can be used to make our lives easier: ScalaLogging offers the class *Logger* with "lightweight" logging methods that will be expanded to the above idiom. So all we have to write is::

  logger.info("Some %s message!".format("expensive"))

In addition ScalaLogging offers the trait *Logging* which conveniently provides a logger instance initialized with the name of the class mixed into::

  class MyClass extends Logging {
    logger.info("This is very convenient ;-)")
  }


Prerequisites
-------------

* Scala 2.10 (because of macros)


Using ScalaLogging
------------------

ScalaLogging is published to the Sonatype OSS snapshot and release repositories. As the Sonatype OSS release repository is mirrored to Maven Central, you can use releases without adding custom resolvers to your sbt build definition or custom repositories to your Maven POM. The organization (group id) is *name.heikoseeberger* and the name (artifact id) is *scalalogging*.

The following example shows how to add a dependency to the latest snapshot version of ScalaLogging to your sbt (0.12 or later) build definition::

  resolvers += Opts.resolver.sonatypeSnapshots

  libraryDependencies += "name.heikoseeberger" %% "scalalogging" % "0.1.0-SNAPSHOT" cross CrossVersion.full


Contribution policy
-------------------

Contributions via GitHub pull requests are gladly accepted from their original author. Along with any pull requests, please state that the contribution is your original work and that you license the work to the project under the project's open source license. Whether or not you state this explicitly, by submitting any copyrighted material via pull request, email, or other means you agree to license the material under the project's open source license and warrant that you have the legal authority to do so.


License
-------

This code is open source software licensed under the `Apache 2.0 License`_. Feel free to use it accordingly.

.. _`JUL to SLF4J bridge`: http://www.slf4j.org/legacy.html#jul-to-slf4j
.. _`Scala macros`: http://scalamacros.org/
.. _`Open Source Exchange Rates`: http://josscrowcroft.github.com/open-exchange-rates/
.. _`Apache 2.0 License`: http://www.apache.org/licenses/LICENSE-2.0.html

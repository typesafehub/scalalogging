ScalaLogging
============

Scala logging library wrapping `SLF4J`_.

In principle the evaluation of log messages should be avoided if the given log level is not enabled. Hence we should write the following code to log at the *info* level::

  if (logger.isInfoEnabled) logger.info("Some %s message!" format "expensive")

Yet this idiom is too heavyweight, so that many of us just omit this loggable check, which in turn could lead to a negative impact on performance. Fortunately `Scala macros` can be used to make our lives easier: ScalaLogging offers the class ``Logger`` with lightweight logging methods that will be expanded to the above idiom. So all we have to write is::

  logger.info("Some %s message!" format "expensive")

In addition ScalaLogging offers the trait ``Logging`` which conveniently provides a ``Logger`` instance initialized with the name of the class mixed into::

  class MyClass extends Logging {
    logger.info("This is very convenient ;-)")
  }


Prerequisites
-------------

* Scala 2.10.0-M6


Using ScalaLogging
------------------

ScalaLogging is published to the Sonatype OSS snapshot and release repositories. As the Sonatype OSS release repository is mirrored to Maven Central, you can use releases without adding custom resolvers to your sbt build definition or custom repositories to your Maven POM. The organization (group id) is ``name.heikoseeberger`` and the name (artifact id) is ``scalalogging``.

The following example shows how to add a dependency to the latest **release** version of ScalaLogging to your sbt (0.12.0 or later) build definition::

  libraryDependencies += "name.heikoseeberger" %% "scalalogging" % "0.1.0" cross CrossVersion.full

The following example shows how to add a dependency to the latest **snapshot** version of ScalaLogging to your sbt (0.12.0 or later) build definition::

    resolvers += Opts.resolver.sonatypeReleases

    libraryDependencies += "name.heikoseeberger" %% "scalalogging" % "0.2.0-SNAPSHOT" cross CrossVersion.full


Contribution policy
-------------------

Contributions via GitHub pull requests are gladly accepted from their original author. Along with any pull requests, please state that the contribution is your original work and that you license the work to the project under the project's open source license. Whether or not you state this explicitly, by submitting any copyrighted material via pull request, email, or other means you agree to license the material under the project's open source license and warrant that you have the legal authority to do so.


License
-------

This code is open source software licensed under the `Apache 2.0 License`_. Feel free to use it accordingly.

.. _`SLF4J`: http://www.slf4j.org/
.. _`Scala macros`: http://scalamacros.org/
.. _`Open Source Exchange Rates`: http://josscrowcroft.github.com/open-exchange-rates/
.. _`Apache 2.0 License`: http://www.apache.org/licenses/LICENSE-2.0.html

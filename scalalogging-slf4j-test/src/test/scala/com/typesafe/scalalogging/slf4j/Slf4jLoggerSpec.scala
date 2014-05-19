/*
 * Copyright 2012 Copyright 2012 Typesafe Inc. <http://www.typesafe.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.typesafe.scalalogging.slf4j

import org.slf4j.{ Logger => Underlying, ILoggerFactory, LoggerFactory, MarkerFactory }
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

object Slf4jLoggerSpec extends Specification with Mockito {

  private val Message = "String message!"

  private val AnyRefMessage = new AnyRef

  private val Throwable = new Exception("Exception")

  private val Marker = MarkerFactory getMarker "Marker"

  private val Params = List("1", "2", new java.util.Date(3))

  "Calling error" should {
    "not call the underlying logger if level not enabled" in {
      val underlying = mock[Underlying]
      underlying.isErrorEnabled returns false
      val logger = Logger(underlying)
      logger.error(Message)
      there was no(underlying).error(Message)
      logger.error(Message, "1", "2", new java.util.Date(3))
      there was no(underlying).error(Message, "1", "2", new java.util.Date(3))
      logger.error(Message, Throwable)
      there was no(underlying).error(Message, Throwable)
      logger.error(Marker, Message)
      there was no(underlying).error(Marker, Message)
      logger.error(Marker, Message, Params: _*)
      there was no(underlying).error(Marker, Message, Params: _*)
      logger.error(Marker, Message, Throwable)
      there was no(underlying).error(Marker, Message, Throwable)
    }
    "call the underlying logger if level enabled" in {
      val underlying = mock[Underlying]
      underlying.isErrorEnabled returns true
      val logger = Logger(underlying)
      logger.error(Message)
      there was one(underlying).error(Message)
      logger.error(Message, "1", "2", new java.util.Date(3))
      there was one(underlying).error(Message, "1", "2", new java.util.Date(3))
      logger.error(Message, Throwable)
      there was one(underlying).error(Message, Throwable)
      logger.error(Marker, Message)
      there was one(underlying).error(Marker, Message)
      logger.error(Marker, Message, Params: _*)
      there was one(underlying).error(Marker, Message, Params: _*)
      logger.error(Marker, Message, Throwable)
      there was one(underlying).error(Marker, Message, Throwable)
    }
  }

  "Calling warn" should {
    "not call the underlying logger if level not enabled" in {
      val underlying = mock[Underlying]
      underlying.isWarnEnabled returns false
      val logger = Logger(underlying)
      logger.warn(Message)
      there was no(underlying).warn(Message)
      logger.warn(Message, "1", "2", new java.util.Date(3))
      there was no(underlying).warn(Message, "1", "2", new java.util.Date(3))
      logger.warn(Message, Throwable)
      there was no(underlying).warn(Message, Throwable)
      logger.warn(Marker, Message)
      there was no(underlying).warn(Marker, Message)
      logger.warn(Marker, Message, Params: _*)
      there was no(underlying).warn(Marker, Message, Params: _*)
      logger.warn(Marker, Message, Throwable)
      there was no(underlying).warn(Marker, Message, Throwable)
    }
    "call the underlying logger if level enabled" in {
      val underlying = mock[Underlying]
      underlying.isWarnEnabled returns true
      val logger = Logger(underlying)
      logger.warn(Message)
      there was one(underlying).warn(Message)
      logger.warn(Message, "1", "2", new java.util.Date(3))
      there was one(underlying).warn(Message, "1", "2", new java.util.Date(3))
      logger.warn(Message, Throwable)
      there was one(underlying).warn(Message, Throwable)
      logger.warn(Marker, Message)
      there was one(underlying).warn(Marker, Message)
      logger.warn(Marker, Message, Params: _*)
      there was one(underlying).warn(Marker, Message, Params: _*)
      logger.warn(Marker, Message, Throwable)
      there was one(underlying).warn(Marker, Message, Throwable)
    }
  }

  "Calling info" should {
    "not call the underlying logger if level not enabled" in {
      val underlying = mock[Underlying]
      underlying.isInfoEnabled returns false
      val logger = Logger(underlying)
      logger.info(Message)
      there was no(underlying).info(Message)
      logger.info(Message, "1", "2", new java.util.Date(3))
      there was no(underlying).info(Message, "1", "2", new java.util.Date(3))
      logger.info(Message, Throwable)
      there was no(underlying).info(Message, Throwable)
      logger.info(Marker, Message)
      there was no(underlying).info(Marker, Message)
      logger.info(Marker, Message, Params: _*)
      there was no(underlying).info(Marker, Message, Params: _*)
      logger.info(Marker, Message, Throwable)
      there was no(underlying).info(Marker, Message, Throwable)
    }
    "call the underlying logger if level enabled" in {
      val underlying = mock[Underlying]
      underlying.isInfoEnabled returns true
      val logger = Logger(underlying)
      logger.info(Message)
      there was one(underlying).info(Message)
      logger.info(Message, "1", "2", new java.util.Date(3))
      there was one(underlying).info(Message, "1", "2", new java.util.Date(3))
      logger.info(Message, Throwable)
      there was one(underlying).info(Message, Throwable)
      logger.info(Marker, Message)
      there was one(underlying).info(Marker, Message)
      logger.info(Marker, Message, Params: _*)
      there was one(underlying).info(Marker, Message, Params: _*)
      logger.info(Marker, Message, Throwable)
      there was one(underlying).info(Marker, Message, Throwable)
    }
  }

  "Calling debug" should {
    "not call the underlying logger if level not enabled" in {
      val underlying = mock[Underlying]
      underlying.isDebugEnabled returns false
      val logger = Logger(underlying)
      logger.debug(Message)
      there was no(underlying).debug(Message)
      logger.debug(Message, "1", "2", new java.util.Date(3))
      there was no(underlying).debug(Message, "1", "2", new java.util.Date(3))
      logger.debug(Message, Throwable)
      there was no(underlying).debug(Message, Throwable)
      logger.debug(Marker, Message)
      there was no(underlying).debug(Marker, Message)
      logger.debug(Marker, Message, Params: _*)
      there was no(underlying).debug(Marker, Message, Params: _*)
      logger.debug(Marker, Message, Throwable)
      there was no(underlying).debug(Marker, Message, Throwable)
    }
    "call the underlying logger if level enabled" in {
      val underlying = mock[Underlying]
      underlying.isDebugEnabled returns true
      val logger = Logger(underlying)
      logger.debug(Message)
      there was one(underlying).debug(Message)
      logger.debug(Message, "1", "2", new java.util.Date(3))
      there was one(underlying).debug(Message, "1", "2", new java.util.Date(3))
      logger.debug(Message, Throwable)
      there was one(underlying).debug(Message, Throwable)
      logger.debug(Marker, Message)
      there was one(underlying).debug(Marker, Message)
      logger.debug(Marker, Message, Params: _*)
      there was one(underlying).debug(Marker, Message, Params: _*)
      logger.debug(Marker, Message, Throwable)
      there was one(underlying).debug(Marker, Message, Throwable)
    }
  }

  "Calling trace" should {
    "not call the underlying logger if level not enabled" in {
      val underlying = mock[Underlying]
      underlying.isTraceEnabled returns false
      val logger = Logger(underlying)
      logger.trace(Message)
      there was no(underlying).trace(Message)
      logger.trace(Message, "1", "2", new java.util.Date(3))
      there was no(underlying).trace(Message, "1", "2", new java.util.Date(3))
      logger.trace(Message, Throwable)
      there was no(underlying).trace(Message, Throwable)
      logger.trace(Marker, Message)
      there was no(underlying).trace(Marker, Message)
      logger.trace(Marker, Message, Params: _*)
      there was no(underlying).trace(Marker, Message, Params: _*)
      logger.trace(Marker, Message, Throwable)
      there was no(underlying).trace(Marker, Message, Throwable)
    }
    "call the underlying logger if level enabled" in {
      val underlying = mock[Underlying]
      underlying.isTraceEnabled returns true
      val logger = Logger(underlying)
      logger.trace(Message)
      there was one(underlying).trace(Message)
      logger.trace(Message, "1", "2", new java.util.Date(3))
      there was one(underlying).trace(Message, "1", "2", new java.util.Date(3))
      logger.trace(Message, Throwable)
      there was one(underlying).trace(Message, Throwable)
      logger.trace(Marker, Message)
      there was one(underlying).trace(Marker, Message)
      logger.trace(Marker, Message, Params: _*)
      there was one(underlying).trace(Marker, Message, Params: _*)
      logger.trace(Marker, Message, Throwable)
      there was one(underlying).trace(Marker, Message, Throwable)
    }
  }

  "Creating logger" should {
    "provide correct logger name" in {
      val ilfSpy = spy(LoggerFactory.getILoggerFactory)
      new TestSuperclass(ilfSpy)
      there was one(ilfSpy).getLogger("com.typesafe.scalalogging.slf4j.TestSuperclass")

      new TestSubclass(ilfSpy)
      there was one(ilfSpy).getLogger("com.typesafe.scalalogging.slf4j.TestSubclass")
    }
  }
}

class TestSuperclass(iLoggerFactory: ILoggerFactory) {
  Logger(iLoggerFactory)
}

class TestSubclass(iLoggerFactory: ILoggerFactory) extends TestSuperclass(iLoggerFactory) {
  Logger(iLoggerFactory)
}

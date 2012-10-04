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

package com.typesafe.scalalogging.log4j

import org.apache.logging.log4j.{ Logger => Underlying, MarkerManager }
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

object Log4jLoggerSpec extends Specification with Mockito {

  private val Message = "String message!"

  private val AnyRefMessage = new AnyRef

  private val Cause = new Exception("Exception")

  private val Marker = MarkerManager getMarker "Marker"

  private val Params = List("1", "2", new java.util.Date(3))

  "Calling fatal" should {
    "not call the underlying logger if level not enabled" in {
      val underlying = mock[Underlying]
      underlying.isFatalEnabled returns false
      val logger = Logger(underlying)
      logger.fatal(Message)
      there was no(underlying).fatal(Message)
      logger.fatal(Marker, Message)
      there was no(underlying).fatal(Marker, Message)
      logger.fatal(Message, Cause)
      there was no(underlying).fatal(Message, Cause)
      logger.fatal(Marker, Message, Cause)
      there was no(underlying).fatal(Marker, Message, Cause)
      logger.fatal(AnyRefMessage)
      there was no(underlying).fatal(AnyRefMessage)
      logger.fatal(Marker, AnyRefMessage)
      there was no(underlying).fatal(Marker, AnyRefMessage)
      logger.fatal(AnyRefMessage, Cause)
      there was no(underlying).fatal(AnyRefMessage, Cause)
      logger.fatal(Marker, AnyRefMessage, Cause)
      there was no(underlying).fatal(Marker, AnyRefMessage, Cause)
      logger.fatal(Message, Params: _*)
      there was no(underlying).fatal(Message, Params: _*)
      logger.fatal(Marker, Message, Params: _*)
      there was no(underlying).fatal(Marker, Message, Params: _*)
    }
    "call the underlying logger if level enabled" in {
      val underlying = mock[Underlying]
      underlying.isFatalEnabled returns true
      val logger = Logger(underlying)
      logger.fatal(Message)
      there was one(underlying).fatal(Message)
      logger.fatal(Marker, Message)
      there was one(underlying).fatal(Marker, Message)
      logger.fatal(Message, Cause)
      there was one(underlying).fatal(Message, Cause)
      logger.fatal(Marker, Message, Cause)
      there was one(underlying).fatal(Marker, Message, Cause)
      logger.fatal(AnyRefMessage)
      there was one(underlying).fatal(AnyRefMessage)
      logger.fatal(Marker, AnyRefMessage)
      there was one(underlying).fatal(Marker, AnyRefMessage)
      logger.fatal(AnyRefMessage, Cause)
      there was one(underlying).fatal(AnyRefMessage, Cause)
      logger.fatal(Marker, AnyRefMessage, Cause)
      there was one(underlying).fatal(Marker, AnyRefMessage, Cause)
      logger.fatal(Message, Params: _*)
      there was one(underlying).fatal(Message, Params: _*)
      logger.fatal(Marker, Message, Params: _*)
      there was one(underlying).fatal(Marker, Message, Params: _*)
    }
  }

  "Calling error" should {
    "not call the underlying logger if level not enabled" in {
      val underlying = mock[Underlying]
      underlying.isErrorEnabled returns false
      val logger = Logger(underlying)
      logger.error(Message)
      there was no(underlying).error(Message)
      logger.error(Marker, Message)
      there was no(underlying).error(Marker, Message)
      logger.error(Message, Cause)
      there was no(underlying).error(Message, Cause)
      logger.error(Marker, Message, Cause)
      there was no(underlying).error(Marker, Message, Cause)
      logger.error(AnyRefMessage)
      there was no(underlying).error(AnyRefMessage)
      logger.error(Marker, AnyRefMessage)
      there was no(underlying).error(Marker, AnyRefMessage)
      logger.error(AnyRefMessage, Cause)
      there was no(underlying).error(AnyRefMessage, Cause)
      logger.error(Marker, AnyRefMessage, Cause)
      there was no(underlying).error(Marker, AnyRefMessage, Cause)
      logger.error(Message, Params: _*)
      there was no(underlying).error(Message, Params: _*)
      logger.error(Marker, Message, Params: _*)
      there was no(underlying).error(Marker, Message, Params: _*)
    }
    "call the underlying logger if level enabled" in {
      val underlying = mock[Underlying]
      underlying.isErrorEnabled returns true
      val logger = Logger(underlying)
      logger.error(Message)
      there was one(underlying).error(Message)
      logger.error(Marker, Message)
      there was one(underlying).error(Marker, Message)
      logger.error(Message, Cause)
      there was one(underlying).error(Message, Cause)
      logger.error(Marker, Message, Cause)
      there was one(underlying).error(Marker, Message, Cause)
      logger.error(AnyRefMessage)
      there was one(underlying).error(AnyRefMessage)
      logger.error(Marker, AnyRefMessage)
      there was one(underlying).error(Marker, AnyRefMessage)
      logger.error(AnyRefMessage, Cause)
      there was one(underlying).error(AnyRefMessage, Cause)
      logger.error(Marker, AnyRefMessage, Cause)
      there was one(underlying).error(Marker, AnyRefMessage, Cause)
      logger.error(Message, Params: _*)
      there was one(underlying).error(Message, Params: _*)
      logger.error(Marker, Message, Params: _*)
      there was one(underlying).error(Marker, Message, Params: _*)
    }
  }

  "Calling warn" should {
    "not call the underlying logger if level not enabled" in {
      val underlying = mock[Underlying]
      underlying.isWarnEnabled returns false
      val logger = Logger(underlying)
      logger.warn(Message)
      there was no(underlying).warn(Message)
      logger.warn(Marker, Message)
      there was no(underlying).warn(Marker, Message)
      logger.warn(Message, Cause)
      there was no(underlying).warn(Message, Cause)
      logger.warn(Marker, Message, Cause)
      there was no(underlying).warn(Marker, Message, Cause)
      logger.warn(AnyRefMessage)
      there was no(underlying).warn(AnyRefMessage)
      logger.warn(Marker, AnyRefMessage)
      there was no(underlying).warn(Marker, AnyRefMessage)
      logger.warn(AnyRefMessage, Cause)
      there was no(underlying).warn(AnyRefMessage, Cause)
      logger.warn(Marker, AnyRefMessage, Cause)
      there was no(underlying).warn(Marker, AnyRefMessage, Cause)
      logger.warn(Message, Params: _*)
      there was no(underlying).warn(Message, Params: _*)
      logger.warn(Marker, Message, Params: _*)
      there was no(underlying).warn(Marker, Message, Params: _*)
    }
    "call the underlying logger if level enabled" in {
      val underlying = mock[Underlying]
      underlying.isWarnEnabled returns true
      val logger = Logger(underlying)
      logger.warn(Message)
      there was one(underlying).warn(Message)
      logger.warn(Marker, Message)
      there was one(underlying).warn(Marker, Message)
      logger.warn(Message, Cause)
      there was one(underlying).warn(Message, Cause)
      logger.warn(Marker, Message, Cause)
      there was one(underlying).warn(Marker, Message, Cause)
      logger.warn(AnyRefMessage)
      there was one(underlying).warn(AnyRefMessage)
      logger.warn(Marker, AnyRefMessage)
      there was one(underlying).warn(Marker, AnyRefMessage)
      logger.warn(AnyRefMessage, Cause)
      there was one(underlying).warn(AnyRefMessage, Cause)
      logger.warn(Marker, AnyRefMessage, Cause)
      there was one(underlying).warn(Marker, AnyRefMessage, Cause)
      logger.warn(Message, Params: _*)
      there was one(underlying).warn(Message, Params: _*)
      logger.warn(Marker, Message, Params: _*)
      there was one(underlying).warn(Marker, Message, Params: _*)
    }
  }

  "Calling info" should {
    "not call the underlying logger if level not enabled" in {
      val underlying = mock[Underlying]
      underlying.isInfoEnabled returns false
      val logger = Logger(underlying)
      logger.info(Message)
      there was no(underlying).info(Message)
      logger.info(Marker, Message)
      there was no(underlying).info(Marker, Message)
      logger.info(Message, Cause)
      there was no(underlying).info(Message, Cause)
      logger.info(Marker, Message, Cause)
      there was no(underlying).info(Marker, Message, Cause)
      logger.info(AnyRefMessage)
      there was no(underlying).info(AnyRefMessage)
      logger.info(Marker, AnyRefMessage)
      there was no(underlying).info(Marker, AnyRefMessage)
      logger.info(AnyRefMessage, Cause)
      there was no(underlying).info(AnyRefMessage, Cause)
      logger.info(Marker, AnyRefMessage, Cause)
      there was no(underlying).info(Marker, AnyRefMessage, Cause)
      logger.info(Message, Params: _*)
      there was no(underlying).info(Message, Params: _*)
      logger.info(Marker, Message, Params: _*)
      there was no(underlying).info(Marker, Message, Params: _*)
    }
    "call the underlying logger if level enabled" in {
      val underlying = mock[Underlying]
      underlying.isInfoEnabled returns true
      val logger = Logger(underlying)
      logger.info(Message)
      there was one(underlying).info(Message)
      logger.info(Marker, Message)
      there was one(underlying).info(Marker, Message)
      logger.info(Message, Cause)
      there was one(underlying).info(Message, Cause)
      logger.info(Marker, Message, Cause)
      there was one(underlying).info(Marker, Message, Cause)
      logger.info(AnyRefMessage)
      there was one(underlying).info(AnyRefMessage)
      logger.info(Marker, AnyRefMessage)
      there was one(underlying).info(Marker, AnyRefMessage)
      logger.info(AnyRefMessage, Cause)
      there was one(underlying).info(AnyRefMessage, Cause)
      logger.info(Marker, AnyRefMessage, Cause)
      there was one(underlying).info(Marker, AnyRefMessage, Cause)
      logger.info(Message, Params: _*)
      there was one(underlying).info(Message, Params: _*)
      logger.info(Marker, Message, Params: _*)
      there was one(underlying).info(Marker, Message, Params: _*)
    }
  }

  "Calling debug" should {
    "not call the underlying logger if level not enabled" in {
      val underlying = mock[Underlying]
      underlying.isDebugEnabled returns false
      val logger = Logger(underlying)
      logger.debug(Message)
      there was no(underlying).debug(Message)
      logger.debug(Marker, Message)
      there was no(underlying).debug(Marker, Message)
      logger.debug(Message, Cause)
      there was no(underlying).debug(Message, Cause)
      logger.debug(Marker, Message, Cause)
      there was no(underlying).debug(Marker, Message, Cause)
      logger.debug(AnyRefMessage)
      there was no(underlying).debug(AnyRefMessage)
      logger.debug(Marker, AnyRefMessage)
      there was no(underlying).debug(Marker, AnyRefMessage)
      logger.debug(AnyRefMessage, Cause)
      there was no(underlying).debug(AnyRefMessage, Cause)
      logger.debug(Marker, AnyRefMessage, Cause)
      there was no(underlying).debug(Marker, AnyRefMessage, Cause)
      logger.debug(Message, Params: _*)
      there was no(underlying).debug(Message, Params: _*)
      logger.debug(Marker, Message, Params: _*)
      there was no(underlying).debug(Marker, Message, Params: _*)
    }
    "call the underlying logger if level enabled" in {
      val underlying = mock[Underlying]
      underlying.isDebugEnabled returns true
      val logger = Logger(underlying)
      logger.debug(Message)
      there was one(underlying).debug(Message)
      logger.debug(Marker, Message)
      there was one(underlying).debug(Marker, Message)
      logger.debug(Message, Cause)
      there was one(underlying).debug(Message, Cause)
      logger.debug(Marker, Message, Cause)
      there was one(underlying).debug(Marker, Message, Cause)
      logger.debug(AnyRefMessage)
      there was one(underlying).debug(AnyRefMessage)
      logger.debug(Marker, AnyRefMessage)
      there was one(underlying).debug(Marker, AnyRefMessage)
      logger.debug(AnyRefMessage, Cause)
      there was one(underlying).debug(AnyRefMessage, Cause)
      logger.debug(Marker, AnyRefMessage, Cause)
      there was one(underlying).debug(Marker, AnyRefMessage, Cause)
      logger.debug(Message, Params: _*)
      there was one(underlying).debug(Message, Params: _*)
      logger.debug(Marker, Message, Params: _*)
      there was one(underlying).debug(Marker, Message, Params: _*)
    }
  }

  "Calling trace" should {
    "not call the underlying logger if level not enabled" in {
      val underlying = mock[Underlying]
      underlying.isTraceEnabled returns false
      val logger = Logger(underlying)
      logger.trace(Message)
      there was no(underlying).trace(Message)
      logger.trace(Marker, Message)
      there was no(underlying).trace(Marker, Message)
      logger.trace(Message, Cause)
      there was no(underlying).trace(Message, Cause)
      logger.trace(Marker, Message, Cause)
      there was no(underlying).trace(Marker, Message, Cause)
      logger.trace(AnyRefMessage)
      there was no(underlying).trace(AnyRefMessage)
      logger.trace(Marker, AnyRefMessage)
      there was no(underlying).trace(Marker, AnyRefMessage)
      logger.trace(AnyRefMessage, Cause)
      there was no(underlying).trace(AnyRefMessage, Cause)
      logger.trace(Marker, AnyRefMessage, Cause)
      there was no(underlying).trace(Marker, AnyRefMessage, Cause)
      logger.trace(Message, Params: _*)
      there was no(underlying).trace(Message, Params: _*)
      logger.trace(Marker, Message, Params: _*)
      there was no(underlying).trace(Marker, Message, Params: _*)
    }
    "call the underlying logger if level enabled" in {
      val underlying = mock[Underlying]
      underlying.isTraceEnabled returns true
      val logger = Logger(underlying)
      logger.trace(Message)
      there was one(underlying).trace(Message)
      logger.trace(Marker, Message)
      there was one(underlying).trace(Marker, Message)
      logger.trace(Message, Cause)
      there was one(underlying).trace(Message, Cause)
      logger.trace(Marker, Message, Cause)
      there was one(underlying).trace(Marker, Message, Cause)
      logger.trace(AnyRefMessage)
      there was one(underlying).trace(AnyRefMessage)
      logger.trace(Marker, AnyRefMessage)
      there was one(underlying).trace(Marker, AnyRefMessage)
      logger.trace(AnyRefMessage, Cause)
      there was one(underlying).trace(AnyRefMessage, Cause)
      logger.trace(Marker, AnyRefMessage, Cause)
      there was one(underlying).trace(Marker, AnyRefMessage, Cause)
      logger.trace(Message, Params: _*)
      there was one(underlying).trace(Message, Params: _*)
      logger.trace(Marker, Message, Params: _*)
      there was one(underlying).trace(Marker, Message, Params: _*)
    }
  }
}

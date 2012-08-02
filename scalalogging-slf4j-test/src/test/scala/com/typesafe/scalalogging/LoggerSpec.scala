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

package com.typesafe.scalalogging

import org.slf4j.{ Logger => Underlying }
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

object LoggerSpec extends Specification with Mockito {

  private val Message = "Some log message!"

  "Calling a not-enabled logging method" should {
    "result in the underlying method not being called" in {
      val underlying = mock[Underlying]
      underlying.isTraceEnabled returns false
      val logger = Logger(underlying)
      logger.trace(Message)
      there was no(underlying).trace(Message)
      logger.trace(Message, "p1")
      there was no(underlying).trace(Message, "p1")
      logger.trace(Message, "p1", "p2")
      there was no(underlying).trace(Message, "p1", "p2")
      logger.trace(Message, Array("p1", "p2", "p3"))
      there was no(underlying).trace(Message, Array("p1", "p2", "p3"))
    }
  }

  "Calling the enabled error method" should {
    "result in the underlying method being called" in {
      val underlying = mock[Underlying]
      underlying.isErrorEnabled returns true
      val logger = Logger(underlying)
      logger.error(Message)
      there was one(underlying).error(Message)
      logger.error(Message, "p1")
      there was one(underlying).error(Message, "p1")
      logger.error(Message, "p1", "p2")
      there was one(underlying).error(Message, "p1", "p2")
      logger.error(Message, Array("p1", "p2", "p3"))
      there was one(underlying).error(Message, Array("p1", "p2", "p3"))
    }
  }

  "Calling the enabled warn method" should {
    "result in the underlying method being called" in {
      val underlying = mock[Underlying]
      underlying.isWarnEnabled returns true
      val logger = Logger(underlying)
      logger.warn(Message)
      there was one(underlying).warn(Message)
      logger.warn(Message, "p1")
      there was one(underlying).warn(Message, "p1")
      logger.warn(Message, "p1", "p2")
      there was one(underlying).warn(Message, "p1", "p2")
      logger.warn(Message, Array("p1", "p2", "p3"))
      there was one(underlying).warn(Message, Array("p1", "p2", "p3"))
    }
  }

  "Calling the enabled info method" should {
    "result in the underlying method being called" in {
      val underlying = mock[Underlying]
      underlying.isInfoEnabled returns true
      val logger = Logger(underlying)
      logger.info(Message)
      there was one(underlying).info(Message)
      logger.info(Message, "p1")
      there was one(underlying).info(Message, "p1")
      logger.info(Message, "p1", "p2")
      there was one(underlying).info(Message, "p1", "p2")
      logger.info(Message, Array("p1", "p2", "p3"))
      there was one(underlying).info(Message, Array("p1", "p2", "p3"))
    }
  }

  "Calling the enabled debug method" should {
    "result in the underlying method being called" in {
      val underlying = mock[Underlying]
      underlying.isDebugEnabled returns true
      val logger = Logger(underlying)
      logger.debug(Message)
      there was one(underlying).debug(Message)
      logger.debug(Message, "p1")
      there was one(underlying).debug(Message, "p1")
      logger.debug(Message, "p1", "p2")
      there was one(underlying).debug(Message, "p1", "p2")
      logger.debug(Message, Array("p1", "p2", "p3"))
      there was one(underlying).debug(Message, Array("p1", "p2", "p3"))
    }
  }

  "Calling the enabled trace method" should {
    "result in the underlying method being called" in {
      val underlying = mock[Underlying]
      underlying.isTraceEnabled returns true
      val logger = Logger(underlying)
      logger.trace(Message)
      there was one(underlying).trace(Message)
      logger.trace(Message, "p1")
      there was one(underlying).trace(Message, "p1")
      logger.trace(Message, "p1", "p2")
      there was one(underlying).trace(Message, "p1", "p2")
      logger.trace(Message, Array("p1", "p2", "p3"))
      there was one(underlying).trace(Message, Array("p1", "p2", "p3"))
    }
  }
}

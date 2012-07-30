/*
 * Copyright 2012 Heiko Seeberger
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

package name.heikoseeberger.scalalogging

import java.util.logging.{ Level, Logger => JLogger }
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

object LoggerSpec extends Specification with Mockito {

  private val Message = "Some log message!"

  "Calling trace" should {
    "not result in calling JLogger.log(Level.FINEST, ...)" in {
      val jLogger = mock[JLogger]
      jLogger.isLoggable(Level.FINEST) returns false
      val logger = Logger(jLogger)
      logger.trace(Message)
      there was no(jLogger).log(Level.FINEST, Message)
    }
  }

  "Calling error" should {
    "result in calling JLogger.log(Level.SEVERE, ...)" in {
      val jLogger = mock[JLogger]
      jLogger.isLoggable(Level.SEVERE) returns true
      val logger = Logger(jLogger)
      logger.error(Message)
      there was one(jLogger).log(Level.SEVERE, Message)
    }
  }
}

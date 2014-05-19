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

import com.typesafe.scalalogging.AbstractLogging

import org.apache.logging.log4j.LogManager

/**
 * Adds the lazy val `logger` of type [[$Logger]] to the class into which this trait is mixed.
 *
 * If you need a non-lazy [[$Logger]], which would probably be a special case,
 * use [[com.typesafe.scalalogging.log4j.StrictLogging]].
 *
 * @define Logger com.typesafe.scalalogging.log4j.Logger
 */
trait Logging extends AbstractLogging {

  override protected lazy val logger: Logger =
    Logger(LogManager getLogger getClass.getName)
}

/**
 * Adds the non-lazy val `logger` of type [[$Logger]] to the class into which this trait is mixed.
 *
 * If you need a lazy [[$Logger]], which would probably be preferrable,
 * use [[com.typesafe.scalalogging.log4j.Logging]].
 *
 * @define Logger com.typesafe.scalalogging.log4j.Logger
 */
trait StrictLogging extends AbstractLogging {

  override protected val logger: Logger =
    Logger(LogManager getLogger getClass.getName)
}

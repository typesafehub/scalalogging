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

/**
 * Example
 */
case class LogExample(name: String) extends Logging {

  private def method0() {
    // default severity is INFO (see: ~jre/lib/logging.properties), so this message is not logged.
    logger.debug("method0 => a debug message")
  }

  private def method1() {
    logger.info(s"method1 => Hey ${name}. How are you.")
  }

  private def method2() {
    logger.warn("method2 => a warning message")
  }

  def all() = {
    method0
    method1
    method2
  }
}

/**
 * Example main
 * If you want change configuration of jdk logger,
 * run program with the option -Djava.util.logging.config.file={your-file-path}.
 *
 */
object Slf4jLogExample extends App {
  LogExample("You") all
}


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

/**
 * Class with several methods
 */
case class LogMe(default: String = "Hello world") extends Logging {

  lazy val greetings = {
    logger.debug("greetings value retrieved!")
    println("a to je fakt divne")
    s"${default}"
  }

  /**
   * log string: method1 - value: v=3
   */
  private def method1() {
    val v = 3
    logger.info(s"method1 => value: v=${v}")
  }

  /**
   *
   */
  private def method2() {
    logger.debug("method2 => " + greetings)
  }

  private def method3() {
    logger.info("method3 => " + greetings)
  }

  def all() = {
    method1
    method2
    method3
  }
}

/**
 * Application main
 * User: JuBu
 * Date: 10.8.2013
 */
object Log4jLogExample extends App {
  LogMe() all
}


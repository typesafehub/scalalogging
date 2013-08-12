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
 * Example
 */
case class LogExample(name: String) extends Logging {

  lazy val greetings = {
    logger.info("greetings value retrieved!")
    s"Hey ${name}, welcome to the world of optimized logging."
  }

  private def method1() {
    val v = 3
    // log value
    logger.info(s"method1 => value: v=${v}")
  }

  private def method2() {
    // this log doesn't appear, because severity in log4j.xml is INFO
    logger.debug("method2 => " + greetings)
  }

  private def method3() {
    logger.info("method3-begin")
    // before this log, is called log defined in body of val greetings.
    logger.info("method3 => " + greetings)
    logger.info("method3-end")
  }

  private def method4() {
    // because greetings is lazy val and was accessed in method3.
    // there is only one log message there
    logger.info("method4 => " + greetings)
  }

  def all() = {
    method1
    method2
    method3
    method4
  }
}

/**
 * Example main
 */
object Log4jLogExample extends App {
  LogExample("You") all
}


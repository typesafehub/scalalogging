/*
 * Copyright 2012 Typesafe Inc. <http://www.typesafe.com>
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

import language.experimental.macros
import org.slf4j.{ Logger => Underlying }

object Logger {

  /**
   * Create a [[com.typesafe.scalalogging.Logger]] wrapping the given underlying ''org.slf4j.Logger''.
   */
  def apply(underlying: Underlying): Logger =
    new Logger(underlying)
}

/**
 * Convenient and performant wrapper around the given underlying ''org.slf4j.Logger''.
 *
 * Convenient, because you can use string formatting, string interpolation or whatever you want
 * without thinking too much about performance.
 * Performant, because by using macros the log methods are expanded inline to the check-enabled idiom.
 */
final class Logger private (val underlying: Underlying) {

  // Error

  def error(message: String): Unit = macro LoggerMacros.error

  def error(message: String, param: AnyRef): Unit = macro LoggerMacros.errorP

  def error(message: String, param1: AnyRef, param2: AnyRef): Unit = macro LoggerMacros.errorP2

  def error(message: String, params: Array[AnyRef]): Unit = macro LoggerMacros.errorPs

  def error(message: String, t: Throwable): Unit = macro LoggerMacros.errorT

  // Warn

  def warn(message: String): Unit = macro LoggerMacros.warn

  def warn(message: String, param: AnyRef): Unit = macro LoggerMacros.warnP

  def warn(message: String, param1: AnyRef, param2: AnyRef): Unit = macro LoggerMacros.warnP2

  def warn(message: String, params: Array[AnyRef]): Unit = macro LoggerMacros.warnPs

  def warn(message: String, t: Throwable): Unit = macro LoggerMacros.warnT

  // Info

  def info(message: String): Unit = macro LoggerMacros.info

  def info(message: String, param: AnyRef): Unit = macro LoggerMacros.infoP

  def info(message: String, param1: AnyRef, param2: AnyRef): Unit = macro LoggerMacros.infoP2

  def info(message: String, params: Array[AnyRef]): Unit = macro LoggerMacros.infoPs

  def info(message: String, t: Throwable): Unit = macro LoggerMacros.infoT

  // Debug

  def debug(message: String): Unit = macro LoggerMacros.debug

  def debug(message: String, param: AnyRef): Unit = macro LoggerMacros.debugP

  def debug(message: String, param1: AnyRef, param2: AnyRef): Unit = macro LoggerMacros.debugP2

  def debug(message: String, params: Array[AnyRef]): Unit = macro LoggerMacros.debugPs

  def debug(message: String, t: Throwable): Unit = macro LoggerMacros.debugT

  // Trace

  def trace(message: String): Unit = macro LoggerMacros.trace

  def trace(message: String, param: AnyRef): Unit = macro LoggerMacros.traceP

  def trace(message: String, param1: AnyRef, param2: AnyRef): Unit = macro LoggerMacros.traceP2

  def trace(message: String, params: Array[AnyRef]): Unit = macro LoggerMacros.tracePs

  def trace(message: String, t: Throwable): Unit = macro LoggerMacros.traceT
}


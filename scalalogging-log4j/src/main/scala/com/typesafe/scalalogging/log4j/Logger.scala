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

package com.typesafe.scalalogging.log4j

import language.experimental.macros
import org.apache.logging.log4j.{ Logger => Underlying, Marker }

object Logger {

  /**
   * Create a [[com.typesafe.scalalogging.log4j.Logger]] wrapping the given underlying
   * ''org.apache.logging.log4j.Logger''.
   */
  def apply(underlying: Underlying): Logger =
    new Logger(underlying)
}

/**
 * Convenient and performant wrapper around the given underlying ''org.apache.logging.log4j.Logger''.
 *
 * Convenient, because you can use string formatting, string interpolation or whatever you want
 * without thinking too much about performance.
 * Performant, because by using macros the log methods are expanded inline to the check-enabled idiom.
 */
final class Logger private (val underlying: Underlying) {

  // Fatal

  def fatal(message: String): Unit = macro LoggerMacros.fatalMessage

  def fatal(marker: Marker, message: String): Unit = macro LoggerMacros.fatalMarkerMessage

  def fatal(message: String, t: Throwable): Unit = macro LoggerMacros.fatalMessageThrowable

  def fatal(marker: Marker, message: String, t: Throwable): Unit = macro LoggerMacros.fatalMarkerMessageThrowable

  def fatal(message: AnyRef): Unit = macro LoggerMacros.fatalAnyRefMessage

  def fatal(marker: Marker, message: AnyRef): Unit = macro LoggerMacros.fatalMarkerAnyRefMessage

  def fatal(message: AnyRef, t: Throwable): Unit = macro LoggerMacros.fatalAnyRefMessageThrowable

  def fatal(marker: Marker, message: AnyRef, t: Throwable): Unit = macro LoggerMacros.fatalMarkerAnyRefMessageThrowable

  def fatal(message: String, params: AnyRef*): Unit = macro LoggerMacros.fatalMessageParams

  def fatal(marker: Marker, message: String, params: AnyRef*): Unit = macro LoggerMacros.fatalMarkerMessageParams

  // Error

  def error(message: String): Unit = macro LoggerMacros.errorMessage

  def error(marker: Marker, message: String): Unit = macro LoggerMacros.errorMarkerMessage

  def error(message: String, t: Throwable): Unit = macro LoggerMacros.errorMessageThrowable

  def error(marker: Marker, message: String, t: Throwable): Unit = macro LoggerMacros.errorMarkerMessageThrowable

  def error(message: AnyRef): Unit = macro LoggerMacros.errorAnyRefMessage

  def error(marker: Marker, message: AnyRef): Unit = macro LoggerMacros.errorMarkerAnyRefMessage

  def error(message: AnyRef, t: Throwable): Unit = macro LoggerMacros.errorAnyRefMessageThrowable

  def error(marker: Marker, message: AnyRef, t: Throwable): Unit = macro LoggerMacros.errorMarkerAnyRefMessageThrowable

  def error(message: String, params: AnyRef*): Unit = macro LoggerMacros.errorMessageParams

  def error(marker: Marker, message: String, params: AnyRef*): Unit = macro LoggerMacros.errorMarkerMessageParams

  // Warn

  def warn(message: String): Unit = macro LoggerMacros.warnMessage

  def warn(marker: Marker, message: String): Unit = macro LoggerMacros.warnMarkerMessage

  def warn(message: String, t: Throwable): Unit = macro LoggerMacros.warnMessageThrowable

  def warn(marker: Marker, message: String, t: Throwable): Unit = macro LoggerMacros.warnMarkerMessageThrowable

  def warn(message: AnyRef): Unit = macro LoggerMacros.warnAnyRefMessage

  def warn(marker: Marker, message: AnyRef): Unit = macro LoggerMacros.warnMarkerAnyRefMessage

  def warn(message: AnyRef, t: Throwable): Unit = macro LoggerMacros.warnAnyRefMessageThrowable

  def warn(marker: Marker, message: AnyRef, t: Throwable): Unit = macro LoggerMacros.warnMarkerAnyRefMessageThrowable

  def warn(message: String, params: AnyRef*): Unit = macro LoggerMacros.warnMessageParams

  def warn(marker: Marker, message: String, params: AnyRef*): Unit = macro LoggerMacros.warnMarkerMessageParams

  // Info

  def info(message: String): Unit = macro LoggerMacros.infoMessage

  def info(marker: Marker, message: String): Unit = macro LoggerMacros.infoMarkerMessage

  def info(message: String, t: Throwable): Unit = macro LoggerMacros.infoMessageThrowable

  def info(marker: Marker, message: String, t: Throwable): Unit = macro LoggerMacros.infoMarkerMessageThrowable

  def info(message: AnyRef): Unit = macro LoggerMacros.infoAnyRefMessage

  def info(marker: Marker, message: AnyRef): Unit = macro LoggerMacros.infoMarkerAnyRefMessage

  def info(message: AnyRef, t: Throwable): Unit = macro LoggerMacros.infoAnyRefMessageThrowable

  def info(marker: Marker, message: AnyRef, t: Throwable): Unit = macro LoggerMacros.infoMarkerAnyRefMessageThrowable

  def info(message: String, params: AnyRef*): Unit = macro LoggerMacros.infoMessageParams

  def info(marker: Marker, message: String, params: AnyRef*): Unit = macro LoggerMacros.infoMarkerMessageParams

  // Debug

  def debug(message: String): Unit = macro LoggerMacros.debugMessage

  def debug(marker: Marker, message: String): Unit = macro LoggerMacros.debugMarkerMessage

  def debug(message: String, t: Throwable): Unit = macro LoggerMacros.debugMessageThrowable

  def debug(marker: Marker, message: String, t: Throwable): Unit = macro LoggerMacros.debugMarkerMessageThrowable

  def debug(message: AnyRef): Unit = macro LoggerMacros.debugAnyRefMessage

  def debug(marker: Marker, message: AnyRef): Unit = macro LoggerMacros.debugMarkerAnyRefMessage

  def debug(message: AnyRef, t: Throwable): Unit = macro LoggerMacros.debugAnyRefMessageThrowable

  def debug(marker: Marker, message: AnyRef, t: Throwable): Unit = macro LoggerMacros.debugMarkerAnyRefMessageThrowable

  def debug(message: String, params: AnyRef*): Unit = macro LoggerMacros.debugMessageParams

  def debug(marker: Marker, message: String, params: AnyRef*): Unit = macro LoggerMacros.debugMarkerMessageParams

  // Trace

  def trace(message: String): Unit = macro LoggerMacros.traceMessage

  def trace(marker: Marker, message: String): Unit = macro LoggerMacros.traceMarkerMessage

  def trace(message: String, t: Throwable): Unit = macro LoggerMacros.traceMessageThrowable

  def trace(marker: Marker, message: String, t: Throwable): Unit = macro LoggerMacros.traceMarkerMessageThrowable

  def trace(message: AnyRef): Unit = macro LoggerMacros.traceAnyRefMessage

  def trace(marker: Marker, message: AnyRef): Unit = macro LoggerMacros.traceMarkerAnyRefMessage

  def trace(message: AnyRef, t: Throwable): Unit = macro LoggerMacros.traceAnyRefMessageThrowable

  def trace(marker: Marker, message: AnyRef, t: Throwable): Unit = macro LoggerMacros.traceMarkerAnyRefMessageThrowable

  def trace(message: String, params: AnyRef*): Unit = macro LoggerMacros.traceMessageParams

  def trace(marker: Marker, message: String, params: AnyRef*): Unit = macro LoggerMacros.traceMarkerMessageParams
}


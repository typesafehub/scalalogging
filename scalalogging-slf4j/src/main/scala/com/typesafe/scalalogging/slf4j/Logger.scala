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

import com.typesafe.scalalogging.AbstractLogger

import language.experimental.macros
import org.slf4j.{ Logger => Underlying, Marker }

object Logger {

  /**
   * Create a [[com.typesafe.scalalogging.slf4j.Logger]] wrapping the given underlying `org.slf4j.Logger`.
   */
  def apply(underlying: Underlying): Logger =
    new Logger(underlying)
}

/**
 * Convenient and performant wrapper around the given underlying `org.slf4j.Logger`.
 *
 * Convenient, because you can use string formatting, string interpolation or whatever you want
 * without thinking too much about performance.
 * Performant, because by using macros the log methods are expanded inline to the check-enabled idiom.
 */
final class Logger private (val underlying: Underlying)
    extends AbstractLogger {

  // Error

  override def error(message: String): Unit = macro LoggerMacros.errorMessage

  override def error(message: String, params: AnyRef*): Unit = macro LoggerMacros.errorMessageParams

  override def error(message: String, t: Throwable): Unit = macro LoggerMacros.errorMessageThrowable

  def error(marker: Marker, message: String): Unit = macro LoggerMacros.errorMarkerMessage

  def error(marker: Marker, message: String, params: AnyRef*): Unit = macro LoggerMacros.errorMarkerMessageParams

  def error(marker: Marker, message: String, t: Throwable): Unit = macro LoggerMacros.errorMarkerMessageThrowable

  // Warn

  override def warn(message: String): Unit = macro LoggerMacros.warnMessage

  override def warn(message: String, params: AnyRef*): Unit = macro LoggerMacros.warnMessageParams

  override def warn(message: String, t: Throwable): Unit = macro LoggerMacros.warnMessageThrowable

  def warn(marker: Marker, message: String): Unit = macro LoggerMacros.warnMarkerMessage

  def warn(marker: Marker, message: String, params: AnyRef*): Unit = macro LoggerMacros.warnMarkerMessageParams

  def warn(marker: Marker, message: String, t: Throwable): Unit = macro LoggerMacros.warnMarkerMessageThrowable

  // Info

  override def info(message: String): Unit = macro LoggerMacros.infoMessage

  override def info(message: String, params: AnyRef*): Unit = macro LoggerMacros.infoMessageParams

  override def info(message: String, t: Throwable): Unit = macro LoggerMacros.infoMessageThrowable

  def info(marker: Marker, message: String): Unit = macro LoggerMacros.infoMarkerMessage

  def info(marker: Marker, message: String, params: AnyRef*): Unit = macro LoggerMacros.infoMarkerMessageParams

  def info(marker: Marker, message: String, t: Throwable): Unit = macro LoggerMacros.infoMarkerMessageThrowable

  // Debug

  override def debug(message: String): Unit = macro LoggerMacros.debugMessage

  override def debug(message: String, params: AnyRef*): Unit = macro LoggerMacros.debugMessageParams

  override def debug(message: String, t: Throwable): Unit = macro LoggerMacros.debugMessageThrowable

  def debug(marker: Marker, message: String): Unit = macro LoggerMacros.debugMarkerMessage

  def debug(marker: Marker, message: String, params: AnyRef*): Unit = macro LoggerMacros.debugMarkerMessageParams

  def debug(marker: Marker, message: String, t: Throwable): Unit = macro LoggerMacros.debugMarkerMessageThrowable

  // Trace

  override def trace(message: String): Unit = macro LoggerMacros.traceMessage

  override def trace(message: String, params: AnyRef*): Unit = macro LoggerMacros.traceMessageParams

  override def trace(message: String, t: Throwable): Unit = macro LoggerMacros.traceMessageThrowable

  def trace(marker: Marker, message: String): Unit = macro LoggerMacros.traceMarkerMessage

  def trace(marker: Marker, message: String, params: AnyRef*): Unit = macro LoggerMacros.traceMarkerMessageParams

  def trace(marker: Marker, message: String, t: Throwable): Unit = macro LoggerMacros.traceMarkerMessageThrowable
}

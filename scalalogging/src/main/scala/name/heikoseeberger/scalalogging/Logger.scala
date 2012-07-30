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

import language.experimental.macros
import org.slf4j.{ Logger => Underlying }
import scala.reflect.makro.Context

object Logger {

  /**
   * Create a [[name.heikoseeberger.scalalogging.Logger]] wrapping the given underlying ''org.slf4j.Logger''.
   */
  def apply(underlying: Underlying): Logger =
    new Logger(underlying)
}

/**
 * Convenient and performant wrapper around the given underlying ''org.slf4j.Logger''.
 *
 * Convenient, because it is not necessary to write the check-enabled idiom (check whether the a particular log level is enabled) manually.
 * Performant, because by using macros the log methods are expanded inline to the check-enabled idiom.
 */
final class Logger private (val underlying: Underlying) {

  def error(message: String): Unit = macro LoggerMacros.error

  def error(message: String, t: Throwable): Unit = macro LoggerMacros.errorT

  def warn(message: String): Unit = macro LoggerMacros.warn

  def warn(message: String, t: Throwable): Unit = macro LoggerMacros.warnT

  def info(message: String): Unit = macro LoggerMacros.info

  def info(message: String, t: Throwable): Unit = macro LoggerMacros.infoT

  def debug(message: String): Unit = macro LoggerMacros.debug

  def debug(message: String, t: Throwable): Unit = macro LoggerMacros.debugT

  def trace(message: String): Unit = macro LoggerMacros.trace

  def trace(message: String, t: Throwable): Unit = macro LoggerMacros.traceT
}

private object LoggerMacros {

  type LoggerContext = Context { type PrefixType = Logger }

  def error(c: LoggerContext)(message: c.Expr[String]) = c.universe.reify(
    if (c.prefix.splice.underlying.isErrorEnabled) c.prefix.splice.underlying.error(message.splice)
  )

  def errorT(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) = c.universe.reify(
    if (c.prefix.splice.underlying.isErrorEnabled) c.prefix.splice.underlying.error(message.splice, t)
  )

  def warn(c: LoggerContext)(message: c.Expr[String]) = c.universe.reify(
    if (c.prefix.splice.underlying.isWarnEnabled) c.prefix.splice.underlying.warn(message.splice)
  )

  def warnT(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) = c.universe.reify(
    if (c.prefix.splice.underlying.isWarnEnabled) c.prefix.splice.underlying.warn(message.splice, t)
  )

  def info(c: LoggerContext)(message: c.Expr[String]) = c.universe.reify(
    if (c.prefix.splice.underlying.isInfoEnabled) c.prefix.splice.underlying.info(message.splice)
  )

  def infoT(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) = c.universe.reify(
    if (c.prefix.splice.underlying.isInfoEnabled) c.prefix.splice.underlying.info(message.splice, t)
  )

  def debug(c: LoggerContext)(message: c.Expr[String]) = c.universe.reify(
    if (c.prefix.splice.underlying.isDebugEnabled) c.prefix.splice.underlying.debug(message.splice)
  )

  def debugT(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) = c.universe.reify(
    if (c.prefix.splice.underlying.isDebugEnabled) c.prefix.splice.underlying.debug(message.splice, t)
  )

  def trace(c: LoggerContext)(message: c.Expr[String]) = c.universe.reify(
    if (c.prefix.splice.underlying.isTraceEnabled) c.prefix.splice.underlying.trace(message.splice)
  )

  def traceT(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) = c.universe.reify(
    if (c.prefix.splice.underlying.isTraceEnabled) c.prefix.splice.underlying.trace(message.splice, t)
  )
}

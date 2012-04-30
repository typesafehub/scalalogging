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
import language.experimental.macros
import scala.reflect.makro.Context

object Logger {

  /**
   * Create a [[name.heikoseeberger.scalalogging.Logger]] wrapping the given underlying ''java.util.logger.Logger''.
   */
  def apply(underlying: JLogger): Logger = new Logger(underlying)
}

/**
 * Convenient and performant wrapper around the given underlying ''java.util.logger.Logger''.
 *
 * Convenient, because it is not necessary to write the check-enabled idiom (check whether the a particular log level is enabled) manually.
 * Performant, because by using macros the log methods are expanded inline to the check-enabled idiom.
 */
final class Logger private (val underlying: JLogger) {

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

  def error(c: Context { type PrefixType = Logger })(message: c.Expr[String]): c.Expr[Unit] =
    log(c)(c.reify(Level.SEVERE), message, None)

  def errorT(c: Context { type PrefixType = Logger })(message: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] =
    log(c)(c.reify(Level.SEVERE), message, Some(t))

  def warn(c: Context { type PrefixType = Logger })(message: c.Expr[String]): c.Expr[Unit] =
    log(c)(c.reify(Level.WARNING), message, None)

  def warnT(c: Context { type PrefixType = Logger })(message: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] =
    log(c)(c.reify(Level.WARNING), message, Some(t))

  def info(c: Context { type PrefixType = Logger })(message: c.Expr[String]): c.Expr[Unit] =
    log(c)(c.reify(Level.INFO), message, None)

  def infoT(c: Context { type PrefixType = Logger })(message: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] =
    log(c)(c.reify(Level.INFO), message, Some(t))

  def debug(c: Context { type PrefixType = Logger })(message: c.Expr[String]): c.Expr[Unit] =
    log(c)(c.reify(Level.FINE), message, None)

  def debugT(c: Context { type PrefixType = Logger })(message: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] =
    log(c)(c.reify(Level.FINE), message, Some(t))

  def trace(c: Context { type PrefixType = Logger })(message: c.Expr[String]): c.Expr[Unit] =
    log(c)(c.reify(Level.FINEST), message, None)

  def traceT(c: Context { type PrefixType = Logger })(message: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] =
    log(c)(c.reify(Level.FINEST), message, Some(t))

  private def log(c: Context { type PrefixType = Logger })(level: c.Expr[Level], message: c.Expr[String], t: Option[c.Expr[Throwable]]): c.Expr[Unit] = {
    val underlying = c.reify(c.prefix.eval.underlying)
    val effect = t.fold(c.reify(underlying.eval.log(level.eval, message.eval)))(t => c.reify(underlying.eval.log(level.eval, message.eval, t.eval)))
    c.reify(if (underlying.eval.isLoggable(level.eval)) effect.eval)
  }
}

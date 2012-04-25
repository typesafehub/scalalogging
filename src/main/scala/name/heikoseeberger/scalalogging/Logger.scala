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
  def apply(underlying: JLogger): Logger = new Logger(underlying)
}

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
    impl(c)(message, c.reify(Level.SEVERE), None)

  def errorT(c: Context { type PrefixType = Logger })(message: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] =
    impl(c)(message, c.reify(Level.SEVERE), Some(t))

  def warn(c: Context { type PrefixType = Logger })(message: c.Expr[String]): c.Expr[Unit] =
    impl(c)(message, c.reify(Level.WARNING), None)

  def warnT(c: Context { type PrefixType = Logger })(message: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] =
    impl(c)(message, c.reify(Level.WARNING), Some(t))

  def info(c: Context { type PrefixType = Logger })(message: c.Expr[String]): c.Expr[Unit] =
    impl(c)(message, c.reify(Level.INFO), None)

  def infoT(c: Context { type PrefixType = Logger })(message: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] =
    impl(c)(message, c.reify(Level.INFO), Some(t))

  def debug(c: Context { type PrefixType = Logger })(message: c.Expr[String]): c.Expr[Unit] =
    impl(c)(message, c.reify(Level.FINE), None)

  def debugT(c: Context { type PrefixType = Logger })(message: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] =
    impl(c)(message, c.reify(Level.FINE), Some(t))

  def trace(c: Context { type PrefixType = Logger })(message: c.Expr[String]): c.Expr[Unit] =
    impl(c)(message, c.reify(Level.FINEST), None)

  def traceT(c: Context { type PrefixType = Logger })(message: c.Expr[String], t: c.Expr[Throwable]): c.Expr[Unit] =
    impl(c)(message, c.reify(Level.FINEST), Some(t))

  def impl(c: Context { type PrefixType = Logger })(message: c.Expr[String], level: c.Expr[Level], t: Option[c.Expr[Throwable]]): c.Expr[Unit] = {
    val logger = c.reify(c.prefix.eval.underlying)

    val body = t match {
      case Some(tExpr) =>
        c.reify(logger.eval.log(level.eval, message.eval, tExpr.eval))
      case None =>
        c.reify(logger.eval.log(level.eval, message.eval))
    }

    c.reify(if (logger.eval.isLoggable(level.eval)) body.eval)
  }
}

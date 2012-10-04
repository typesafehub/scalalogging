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

import org.apache.logging.log4j.Marker
import scala.reflect.macros.Context

private object LoggerMacros {

  type LoggerContext = Context { type PrefixType = Logger }

  // Fatal

  def fatalMessage(c: LoggerContext)(message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isFatalEnabled)
        c.prefix.splice.underlying.fatal(message.splice)
    )

  def fatalMarkerMessage(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isFatalEnabled)
        c.prefix.splice.underlying.fatal(marker.splice, message.splice)
    )

  def fatalMessageThrowable(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isFatalEnabled)
        c.prefix.splice.underlying.fatal(message.splice, t.splice)
    )

  def fatalMarkerMessageThrowable(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isFatalEnabled)
        c.prefix.splice.underlying.fatal(marker.splice, message.splice, t.splice)
    )

  def fatalAnyRefMessage(c: LoggerContext)(message: c.Expr[AnyRef]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isFatalEnabled)
        c.prefix.splice.underlying.fatal(message.splice)
    )

  def fatalMarkerAnyRefMessage(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[AnyRef]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isFatalEnabled)
        c.prefix.splice.underlying.fatal(marker.splice, message.splice)
    )

  def fatalAnyRefMessageThrowable(c: LoggerContext)(message: c.Expr[AnyRef], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isFatalEnabled)
        c.prefix.splice.underlying.fatal(message.splice, t.splice)
    )

  def fatalMarkerAnyRefMessageThrowable(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[AnyRef], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isFatalEnabled)
        c.prefix.splice.underlying.fatal(marker.splice, message.splice, t.splice)
    )

  def fatalMessageParams(c: LoggerContext)(message: c.Expr[String], params: c.Expr[AnyRef]*) =
    logParams(c)(message, params, None)("fatal")

  def fatalMarkerMessageParams(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], params: c.Expr[AnyRef]*) =
    logParams(c)(message, params, Some(marker))("fatal")

  // Error

  def errorMessage(c: LoggerContext)(message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isErrorEnabled)
        c.prefix.splice.underlying.error(message.splice)
    )

  def errorMarkerMessage(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isErrorEnabled)
        c.prefix.splice.underlying.error(marker.splice, message.splice)
    )

  def errorMessageThrowable(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isErrorEnabled)
        c.prefix.splice.underlying.error(message.splice, t.splice)
    )

  def errorMarkerMessageThrowable(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isErrorEnabled)
        c.prefix.splice.underlying.error(marker.splice, message.splice, t.splice)
    )

  def errorAnyRefMessage(c: LoggerContext)(message: c.Expr[AnyRef]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isErrorEnabled)
        c.prefix.splice.underlying.error(message.splice)
    )

  def errorMarkerAnyRefMessage(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[AnyRef]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isErrorEnabled)
        c.prefix.splice.underlying.error(marker.splice, message.splice)
    )

  def errorAnyRefMessageThrowable(c: LoggerContext)(message: c.Expr[AnyRef], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isErrorEnabled)
        c.prefix.splice.underlying.error(message.splice, t.splice)
    )

  def errorMarkerAnyRefMessageThrowable(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[AnyRef], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isErrorEnabled)
        c.prefix.splice.underlying.error(marker.splice, message.splice, t.splice)
    )

  def errorMessageParams(c: LoggerContext)(message: c.Expr[String], params: c.Expr[AnyRef]*) =
    logParams(c)(message, params, None)("error")

  def errorMarkerMessageParams(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], params: c.Expr[AnyRef]*) =
    logParams(c)(message, params, Some(marker))("error")

  // Warn 

  def warnMessage(c: LoggerContext)(message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isWarnEnabled)
        c.prefix.splice.underlying.warn(message.splice)
    )

  def warnMarkerMessage(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isWarnEnabled)
        c.prefix.splice.underlying.warn(marker.splice, message.splice)
    )

  def warnMessageThrowable(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isWarnEnabled)
        c.prefix.splice.underlying.warn(message.splice, t.splice)
    )

  def warnMarkerMessageThrowable(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isWarnEnabled)
        c.prefix.splice.underlying.warn(marker.splice, message.splice, t.splice)
    )

  def warnAnyRefMessage(c: LoggerContext)(message: c.Expr[AnyRef]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isWarnEnabled)
        c.prefix.splice.underlying.warn(message.splice)
    )

  def warnMarkerAnyRefMessage(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[AnyRef]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isWarnEnabled)
        c.prefix.splice.underlying.warn(marker.splice, message.splice)
    )

  def warnAnyRefMessageThrowable(c: LoggerContext)(message: c.Expr[AnyRef], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isWarnEnabled)
        c.prefix.splice.underlying.warn(message.splice, t.splice)
    )

  def warnMarkerAnyRefMessageThrowable(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[AnyRef], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isWarnEnabled)
        c.prefix.splice.underlying.warn(marker.splice, message.splice, t.splice)
    )

  def warnMessageParams(c: LoggerContext)(message: c.Expr[String], params: c.Expr[AnyRef]*) =
    logParams(c)(message, params, None)("warn")

  def warnMarkerMessageParams(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], params: c.Expr[AnyRef]*) =
    logParams(c)(message, params, Some(marker))("warn")

  // Info 

  def infoMessage(c: LoggerContext)(message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isInfoEnabled)
        c.prefix.splice.underlying.info(message.splice)
    )

  def infoMarkerMessage(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isInfoEnabled)
        c.prefix.splice.underlying.info(marker.splice, message.splice)
    )

  def infoMessageThrowable(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isInfoEnabled)
        c.prefix.splice.underlying.info(message.splice, t.splice)
    )

  def infoMarkerMessageThrowable(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isInfoEnabled)
        c.prefix.splice.underlying.info(marker.splice, message.splice, t.splice)
    )

  def infoAnyRefMessage(c: LoggerContext)(message: c.Expr[AnyRef]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isInfoEnabled)
        c.prefix.splice.underlying.info(message.splice)
    )

  def infoMarkerAnyRefMessage(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[AnyRef]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isInfoEnabled)
        c.prefix.splice.underlying.info(marker.splice, message.splice)
    )

  def infoAnyRefMessageThrowable(c: LoggerContext)(message: c.Expr[AnyRef], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isInfoEnabled)
        c.prefix.splice.underlying.info(message.splice, t.splice)
    )

  def infoMarkerAnyRefMessageThrowable(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[AnyRef], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isInfoEnabled)
        c.prefix.splice.underlying.info(marker.splice, message.splice, t.splice)
    )

  def infoMessageParams(c: LoggerContext)(message: c.Expr[String], params: c.Expr[AnyRef]*) =
    logParams(c)(message, params, None)("info")

  def infoMarkerMessageParams(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], params: c.Expr[AnyRef]*) =
    logParams(c)(message, params, Some(marker))("info")

  // Debug 

  def debugMessage(c: LoggerContext)(message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isDebugEnabled)
        c.prefix.splice.underlying.debug(message.splice)
    )

  def debugMarkerMessage(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isDebugEnabled)
        c.prefix.splice.underlying.debug(marker.splice, message.splice)
    )

  def debugMessageThrowable(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isDebugEnabled)
        c.prefix.splice.underlying.debug(message.splice, t.splice)
    )

  def debugMarkerMessageThrowable(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isDebugEnabled)
        c.prefix.splice.underlying.debug(marker.splice, message.splice, t.splice)
    )

  def debugAnyRefMessage(c: LoggerContext)(message: c.Expr[AnyRef]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isDebugEnabled)
        c.prefix.splice.underlying.debug(message.splice)
    )

  def debugMarkerAnyRefMessage(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[AnyRef]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isDebugEnabled)
        c.prefix.splice.underlying.debug(marker.splice, message.splice)
    )

  def debugAnyRefMessageThrowable(c: LoggerContext)(message: c.Expr[AnyRef], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isDebugEnabled)
        c.prefix.splice.underlying.debug(message.splice, t.splice)
    )

  def debugMarkerAnyRefMessageThrowable(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[AnyRef], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isDebugEnabled)
        c.prefix.splice.underlying.debug(marker.splice, message.splice, t.splice)
    )

  def debugMessageParams(c: LoggerContext)(message: c.Expr[String], params: c.Expr[AnyRef]*) =
    logParams(c)(message, params, None)("debug")

  def debugMarkerMessageParams(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], params: c.Expr[AnyRef]*) =
    logParams(c)(message, params, Some(marker))("debug")

  // Trace 

  def traceMessage(c: LoggerContext)(message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isTraceEnabled)
        c.prefix.splice.underlying.trace(message.splice)
    )

  def traceMarkerMessage(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isTraceEnabled)
        c.prefix.splice.underlying.trace(marker.splice, message.splice)
    )

  def traceMessageThrowable(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isTraceEnabled)
        c.prefix.splice.underlying.trace(message.splice, t.splice)
    )

  def traceMarkerMessageThrowable(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isTraceEnabled)
        c.prefix.splice.underlying.trace(marker.splice, message.splice, t.splice)
    )

  def traceAnyRefMessage(c: LoggerContext)(message: c.Expr[AnyRef]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isTraceEnabled)
        c.prefix.splice.underlying.trace(message.splice)
    )

  def traceMarkerAnyRefMessage(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[AnyRef]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isTraceEnabled)
        c.prefix.splice.underlying.trace(marker.splice, message.splice)
    )

  def traceAnyRefMessageThrowable(c: LoggerContext)(message: c.Expr[AnyRef], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isTraceEnabled)
        c.prefix.splice.underlying.trace(message.splice, t.splice)
    )

  def traceMarkerAnyRefMessageThrowable(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[AnyRef], t: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isTraceEnabled)
        c.prefix.splice.underlying.trace(marker.splice, message.splice, t.splice)
    )

  def traceMessageParams(c: LoggerContext)(message: c.Expr[String], params: c.Expr[AnyRef]*) =
    logParams(c)(message, params, None)("trace")

  def traceMarkerMessageParams(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], params: c.Expr[AnyRef]*) =
    logParams(c)(message, params, Some(marker))("trace")

  // Common

  private def logParams(
    c: LoggerContext)(
      message: c.Expr[String],
      params: Seq[c.Expr[AnyRef]],
      marker: Option[c.Expr[Marker]])(
        level: String) = {
    import c.universe._
    val isEnabled = Select(
      Select(c.prefix.tree, newTermName("underlying")),
      newTermName(s"is${level.head.toUpper +: level.tail}Enabled")
    )
    val log = Apply(
      Select(Select(c.prefix.tree, newTermName("underlying")), newTermName(level)),
      marker.foldRight(message.tree +: (params map (_.tree)).toList)(_.tree +: _)
    )
    c.Expr(If(isEnabled, log, Literal(Constant(()))))
  }
}

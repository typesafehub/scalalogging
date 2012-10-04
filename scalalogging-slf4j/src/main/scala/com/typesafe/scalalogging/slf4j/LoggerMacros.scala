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

import scala.reflect.macros.Context

object LoggerMacros {

  type LoggerContext = Context { type PrefixType = Logger }

  // Errror

  def error(c: LoggerContext)(message: c.Expr[String]) = c.universe.reify(
    if (c.prefix.splice.underlying.isErrorEnabled) c.prefix.splice.underlying.error(message.splice)
  )

  def errorP(c: LoggerContext)(message: c.Expr[String], param: c.Expr[AnyRef]) = c.universe.reify(
    if (c.prefix.splice.underlying.isErrorEnabled)
      c.prefix.splice.underlying.error(message.splice, param.splice)
  )

  def errorP2(c: LoggerContext)(message: c.Expr[String], param1: c.Expr[AnyRef], param2: c.Expr[AnyRef]) = c.universe.reify(
    if (c.prefix.splice.underlying.isErrorEnabled)
      c.prefix.splice.underlying.error(message.splice, param1.splice, param2.splice)
  )

  def errorPs(c: LoggerContext)(message: c.Expr[String], params: c.Expr[Array[AnyRef]]) = c.universe.reify(
    if (c.prefix.splice.underlying.isErrorEnabled)
      c.prefix.splice.underlying.error(message.splice, params.splice)
  )

  def errorT(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) = c.universe.reify(
    if (c.prefix.splice.underlying.isErrorEnabled) c.prefix.splice.underlying.error(message.splice, t.splice)
  )

  // Warn

  def warn(c: LoggerContext)(message: c.Expr[String]) = c.universe.reify(
    if (c.prefix.splice.underlying.isWarnEnabled) c.prefix.splice.underlying.warn(message.splice)
  )

  def warnP(c: LoggerContext)(message: c.Expr[String], param: c.Expr[AnyRef]) = c.universe.reify(
    if (c.prefix.splice.underlying.isWarnEnabled)
      c.prefix.splice.underlying.warn(message.splice, param.splice)
  )

  def warnP2(c: LoggerContext)(message: c.Expr[String], param1: c.Expr[AnyRef], param2: c.Expr[AnyRef]) = c.universe.reify(
    if (c.prefix.splice.underlying.isWarnEnabled)
      c.prefix.splice.underlying.warn(message.splice, param1.splice, param2.splice)
  )

  def warnPs(c: LoggerContext)(message: c.Expr[String], params: c.Expr[Array[AnyRef]]) = c.universe.reify(
    if (c.prefix.splice.underlying.isWarnEnabled)
      c.prefix.splice.underlying.warn(message.splice, params.splice)
  )

  def warnT(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) = c.universe.reify(
    if (c.prefix.splice.underlying.isWarnEnabled) c.prefix.splice.underlying.warn(message.splice, t.splice)
  )

  // Info

  def info(c: LoggerContext)(message: c.Expr[String]) = c.universe.reify(
    if (c.prefix.splice.underlying.isInfoEnabled) c.prefix.splice.underlying.info(message.splice)
  )

  def infoP(c: LoggerContext)(message: c.Expr[String], param: c.Expr[AnyRef]) = c.universe.reify(
    if (c.prefix.splice.underlying.isInfoEnabled)
      c.prefix.splice.underlying.info(message.splice, param.splice)
  )

  def infoP2(c: LoggerContext)(message: c.Expr[String], param1: c.Expr[AnyRef], param2: c.Expr[AnyRef]) = c.universe.reify(
    if (c.prefix.splice.underlying.isInfoEnabled)
      c.prefix.splice.underlying.info(message.splice, param1.splice, param2.splice)
  )

  def infoPs(c: LoggerContext)(message: c.Expr[String], params: c.Expr[Array[AnyRef]]) = c.universe.reify(
    if (c.prefix.splice.underlying.isInfoEnabled)
      c.prefix.splice.underlying.info(message.splice, params.splice)
  )

  def infoT(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) = c.universe.reify(
    if (c.prefix.splice.underlying.isInfoEnabled) c.prefix.splice.underlying.info(message.splice, t.splice)
  )

  // Debug

  def debug(c: LoggerContext)(message: c.Expr[String]) = c.universe.reify(
    if (c.prefix.splice.underlying.isDebugEnabled) c.prefix.splice.underlying.debug(message.splice)
  )

  def debugP(c: LoggerContext)(message: c.Expr[String], param: c.Expr[AnyRef]) = c.universe.reify(
    if (c.prefix.splice.underlying.isDebugEnabled)
      c.prefix.splice.underlying.debug(message.splice, param.splice)
  )

  def debugP2(c: LoggerContext)(message: c.Expr[String], param1: c.Expr[AnyRef], param2: c.Expr[AnyRef]) = c.universe.reify(
    if (c.prefix.splice.underlying.isDebugEnabled)
      c.prefix.splice.underlying.debug(message.splice, param1.splice, param2.splice)
  )

  def debugPs(c: LoggerContext)(message: c.Expr[String], params: c.Expr[Array[AnyRef]]) = c.universe.reify(
    if (c.prefix.splice.underlying.isDebugEnabled)
      c.prefix.splice.underlying.debug(message.splice, params.splice)
  )

  def debugT(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) = c.universe.reify(
    if (c.prefix.splice.underlying.isDebugEnabled) c.prefix.splice.underlying.debug(message.splice, t.splice)
  )

  // Trace

  def trace(c: LoggerContext)(message: c.Expr[String]) = c.universe.reify(
    if (c.prefix.splice.underlying.isTraceEnabled) c.prefix.splice.underlying.trace(message.splice)
  )

  def traceP(c: LoggerContext)(message: c.Expr[String], param: c.Expr[AnyRef]) = c.universe.reify(
    if (c.prefix.splice.underlying.isTraceEnabled)
      c.prefix.splice.underlying.trace(message.splice, param.splice)
  )

  def traceP2(c: LoggerContext)(message: c.Expr[String], param1: c.Expr[AnyRef], param2: c.Expr[AnyRef]) = c.universe.reify(
    if (c.prefix.splice.underlying.isTraceEnabled)
      c.prefix.splice.underlying.trace(message.splice, param1.splice, param2.splice)
  )

  def tracePs(c: LoggerContext)(message: c.Expr[String], params: c.Expr[Array[AnyRef]]) = c.universe.reify(
    if (c.prefix.splice.underlying.isTraceEnabled)
      c.prefix.splice.underlying.trace(message.splice, params.splice)
  )

  def traceT(c: LoggerContext)(message: c.Expr[String], t: c.Expr[Throwable]) = c.universe.reify(
    if (c.prefix.splice.underlying.isTraceEnabled) c.prefix.splice.underlying.trace(message.splice, t.splice)
  )
}
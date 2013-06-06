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

package com.typesafe.scalalogging

/**
 * Convenient and performant wrapper around a given underlying logger.
 *
 * Convenient, because you can use string formatting, string interpolation or whatever you want
 * without thinking too much about performance.
 * Performant, because by using macros the log methods are expanded inline to the check-enabled idiom.
 */
trait AbstractLogger {

  // Fatal

  def fatal(message: String): Unit = {}

  def fatal(message: String, t: Throwable): Unit = {}

  def fatal(message: AnyRef): Unit = {}

  def fatal(message: AnyRef, t: Throwable): Unit = {}

  def fatal(message: String, params: AnyRef*): Unit = {}

  // Error

  def error(message: String): Unit = {}

  def error(message: String, t: Throwable): Unit = {}

  def error(message: AnyRef): Unit = {}

  def error(message: AnyRef, t: Throwable): Unit = {}

  def error(message: String, params: AnyRef*): Unit = {}

  // Warn

  def warn(message: String): Unit = {}

  def warn(message: String, t: Throwable): Unit = {}

  def warn(message: AnyRef): Unit = {}

  def warn(message: AnyRef, t: Throwable): Unit = {}

  def warn(message: String, params: AnyRef*): Unit = {}

  // Info

  def info(message: String): Unit = {}

  def info(message: String, t: Throwable): Unit = {}

  def info(message: AnyRef): Unit = {}

  def info(message: AnyRef, t: Throwable): Unit = {}

  def info(message: String, params: AnyRef*): Unit = {}

  // Debug

  def debug(message: String): Unit = {}

  def debug(message: String, t: Throwable): Unit = {}

  def debug(message: AnyRef): Unit = {}

  def debug(message: AnyRef, t: Throwable): Unit = {}

  def debug(message: String, params: AnyRef*): Unit = {}

  // Trace

  def trace(message: String): Unit = {}

  def trace(message: String, t: Throwable): Unit = {}

  def trace(message: AnyRef): Unit = {}

  def trace(message: AnyRef, t: Throwable): Unit = {}

  def trace(message: String, params: AnyRef*): Unit = {}
}

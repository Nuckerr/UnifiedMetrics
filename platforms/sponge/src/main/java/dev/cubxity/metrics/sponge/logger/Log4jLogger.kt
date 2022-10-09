/*
 *     This file is part of UnifiedMetrics.
 *
 *     UnifiedMetrics is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     UnifiedMetrics is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with UnifiedMetrics.  If not, see <https://www.gnu.org/licenses/>.
 */

package dev.cubxity.metrics.sponge.logger

import dev.cubxity.plugins.metrics.api.logging.Logger
import org.apache.logging.log4j.Level

class Log4jLogger(private val logger: org.apache.logging.log4j.Logger): Logger {
    override fun info(message: String) {
        logger.log(Level.INFO, message)
    }

    override fun warn(message: String) {
        logger.log(Level.WARN, message)
    }

    override fun warn(message: String, error: Throwable) {
        logger.log(Level.WARN, message, error)
    }

    override fun severe(message: String) {
        logger.log(Level.ERROR, message)
    }

    override fun severe(message: String, error: Throwable) {
        logger.log(Level.ERROR, message, error)
    }
}
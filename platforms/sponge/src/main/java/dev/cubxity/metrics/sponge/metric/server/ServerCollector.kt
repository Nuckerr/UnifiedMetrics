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

package dev.cubxity.metrics.sponge.metric.server

import dev.cubxity.metrics.sponge.bootstrap.UnifiedMetricsSpongeBootstrap
import dev.cubxity.plugins.metrics.api.metric.collector.Collector
import dev.cubxity.plugins.metrics.api.metric.data.GaugeMetric
import dev.cubxity.plugins.metrics.api.metric.data.Metric

class ServerCollector(private val bootstrap: UnifiedMetricsSpongeBootstrap): Collector {

    override fun collect(): List<Metric> {
        return listOf(
            GaugeMetric("minecraft_plugins", value = bootstrap.pluginManager.plugins().size),
            GaugeMetric("minecraft_players_count", value = bootstrap.server.onlinePlayers().size),
            GaugeMetric("minecraft_players_max", value = bootstrap.server.maxPlayers())
        )
    }
}
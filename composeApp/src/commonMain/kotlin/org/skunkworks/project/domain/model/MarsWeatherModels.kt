package org.skunkworks.project.domain.model

import kotlin.time.Instant

data class Sol(
    val solNumber: Int,
    val firstUTC: Instant,
    val lastUTC: Instant,
    val season: String,
    val northernSeason: String,
    val southernSeason: String,
    val atmosphericTemp: WeatherMetric?,
    val horizontalWindSpeed: WeatherMetric?,
    val pressure: WeatherMetric?,
    val windDirection: WindDirectionData?
)

data class WeatherMetric(
    val average: Double,
    val min: Double,
    val max: Double,
    val sampleCount: Long
)

data class WindDirectionData(
    val mostCommon: CompassPoint?,
    val readings: List<CompassPoint>
)

data class CompassPoint(
    val degrees: Double,
    val cardinal: String,
    val count: Long
)
package org.skunkworks.project.data.mapper

import org.skunkworks.project.data.remote.dto.CompassPointDto
import org.skunkworks.project.data.remote.dto.MetricDto
import org.skunkworks.project.data.remote.dto.SolDto
import org.skunkworks.project.data.remote.dto.WindDirectionDto
import org.skunkworks.project.domain.model.CompassPoint
import org.skunkworks.project.domain.model.Sol
import org.skunkworks.project.domain.model.WeatherMetric
import org.skunkworks.project.domain.model.WindDirectionData
import kotlin.time.Instant

fun SolDto.toDomain(solNumber: Int): Sol = Sol(
    solNumber = solNumber,
    firstUTC = Instant.parse(firstUTC),
    lastUTC = Instant.parse(lastUTC),
    season = season,
    northernSeason = northernSeason,
    southernSeason = southernSeason,
    atmosphericTemp = atmosphericTemp?.toDomain(),
    horizontalWindSpeed = horizontalWindSpeed?.toDomain(),
    pressure = pressure?.toDomain(),
    windDirection = windDirection?.toDomain()
)

fun MetricDto.toDomain(): WeatherMetric = WeatherMetric(
    average = average,
    min = min,
    max = max,
    sampleCount = count
)

fun WindDirectionDto.toDomain(): WindDirectionData = WindDirectionData(
    mostCommon = mostCommon?.toDomain(),
    readings = emptyList()
)

fun CompassPointDto.toDomain(): CompassPoint = CompassPoint(
    degrees = degrees,
    cardinal = cardinalDirection,
    count = count
)
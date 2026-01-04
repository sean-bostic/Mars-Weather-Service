package org.skunkworks.project.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsWeatherResponseDto(
    @SerialName("sol_keys") val solKeys: List<String>,
)

@Serializable
data class SolDto(
    @SerialName("AT") val atmosphericTemp: MetricDto? = null,
    @SerialName("HWS") val horizontalWindSpeed: MetricDto? = null,
    @SerialName("PRE") val pressure: MetricDto? = null,
    @SerialName("WD") val windDirection: WindDirectionDto? = null,
    @SerialName("First_UTC") val firstUTC: String,
    @SerialName("Last_UTC") val lastUTC: String,
    @SerialName("Season") val season: String,
    @SerialName("Northern_season") val northernSeason: String,
    @SerialName("Southern_season") val southernSeason: String
)

@Serializable
data class MetricDto(
    @SerialName("av") val average: Double,
    @SerialName("mn") val min: Double,
    @SerialName("mx") val max: Double,
    @SerialName("ct") val count: Long
)

@Serializable
data class WindDirectionDto(
    @SerialName("most_common") val mostCommon: CompassPointDto? = null
)

@Serializable
data class CompassPointDto(
    @SerialName("compass_degrees") val degrees: Double,
    @SerialName("compass_point") val cardinalDirection: String,
    @SerialName("ct") val count: Long
)
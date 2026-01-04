package org.skunkworks.project.data.repository

import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive
import org.skunkworks.project.data.mapper.toDomain
import org.skunkworks.project.data.remote.api.MarsWeatherApi
import org.skunkworks.project.data.remote.dto.SolDto
import org.skunkworks.project.domain.model.Sol
import org.skunkworks.project.domain.repository.MarsWeatherRepository
import kotlinx.serialization.json.Json

class MarsWeatherRepositoryImpl(
    private val api: MarsWeatherApi,
    private val json: Json
) : MarsWeatherRepository {

    override suspend fun getLatestSols(): Result<List<Sol>> = runCatching {
        val response: JsonObject = api.getLatestWeather()
        val solKeys = response["sol_keys"]?.jsonArray
            ?.map { it.jsonPrimitive.content }
            ?: emptyList()

        solKeys.mapNotNull { solKey ->
            response[solKey]?.let { solJson ->
                val solDto = json.decodeFromJsonElement<SolDto>(solJson)
                solDto.toDomain(solKey.toInt())
            }
        }
    }
}
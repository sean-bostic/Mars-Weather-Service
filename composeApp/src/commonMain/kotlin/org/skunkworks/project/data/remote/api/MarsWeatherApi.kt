package org.skunkworks.project.data.remote.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.json.*

class MarsWeatherApi(private val client: HttpClient) {

    private val baseUrl = "https://api.nasa.gov/insight_weather/"

    suspend fun getLatestWeather(apiKey: String = "DEMO_KEY"): JsonObject {
        return client.get(baseUrl) {
            parameter("api_key", apiKey)
            parameter("feedtype", "json")
            parameter("ver", "1.0")
        }.body()
    }
}
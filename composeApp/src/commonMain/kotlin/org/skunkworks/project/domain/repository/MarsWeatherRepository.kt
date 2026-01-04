package org.skunkworks.project.domain.repository


import org.skunkworks.project.domain.model.Sol

interface MarsWeatherRepository {
    suspend fun getLatestSols(): Result<List<Sol>>
}
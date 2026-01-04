package org.skunkworks.project.domain.usecase

import org.skunkworks.project.domain.model.Sol
import org.skunkworks.project.domain.repository.MarsWeatherRepository

class GetLatestSolsUseCase(
    private val repository: MarsWeatherRepository
) {
    suspend operator fun invoke(): Result<List<Sol>> = repository.getLatestSols()
}
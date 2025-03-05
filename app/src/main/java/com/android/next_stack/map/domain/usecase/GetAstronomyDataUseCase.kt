package com.android.next_stack.map.domain.usecase


import com.android.next_stack.map.domain.model.astronomy.AstronomyData
import com.android.next_stack.map.domain.repository.AstronomyRepository
import kotlinx.coroutines.flow.Flow

interface GetAstronomyDataUseCase {
    fun invoke(
        latitude: Double,
        longitude: Double,
        startDate: String,
        endDate: String,
        datum: String,
    ): Flow<AstronomyData>
}

class GetAstronomyDataUseCaseImpl(
    private val astronomyRepository: AstronomyRepository,
) : GetAstronomyDataUseCase {

    override fun invoke(
        latitude: Double,
        longitude: Double,
        startDate: String,
        endDate: String,
        datum: String,
    ): Flow<AstronomyData> = astronomyRepository.getAstronomyData(
        latitude = latitude,
        longitude = longitude,
        startDate = startDate,
        endDate = endDate,
        datum = datum
    )

}
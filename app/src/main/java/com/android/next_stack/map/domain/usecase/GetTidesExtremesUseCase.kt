package com.android.next_stack.map.domain.usecase

import com.android.next_stack.map.domain.model.tides.Tide
import com.android.next_stack.map.domain.repository.TidesRepository
import kotlinx.coroutines.flow.Flow

interface GetTidesExtremesUseCase {
    fun invoke(
        latitude: Double,
        longitude: Double,
        startDate: String,
        endDate: String,
        datum: String,
    ): Flow<List<Tide>>
}

class GetTidesExtremesUseCaseImpl(
    private val repository: TidesRepository,
) : GetTidesExtremesUseCase {
    override fun invoke(
        latitude: Double,
        longitude: Double,
        startDate: String,
        endDate: String,
        datum: String,
    ): Flow<List<Tide>> {
        return repository.getTidesExtremes(latitude, longitude, startDate, endDate, datum)
    }
}
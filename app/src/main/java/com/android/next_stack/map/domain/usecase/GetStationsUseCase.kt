package com.android.next_stack.map.domain.usecase

import com.android.next_stack.map.domain.model.station.Station
import com.android.next_stack.map.domain.repository.StationRepository
import kotlinx.coroutines.flow.Flow

interface GetStationUseCase {
    fun invoke(): Flow<List<Station>>
}

class GetStationUseCaseImpl(
    private val repository: StationRepository,
) : GetStationUseCase {
    override fun invoke(

    ): Flow<List<Station>> {
        return repository.getStations()
    }
}
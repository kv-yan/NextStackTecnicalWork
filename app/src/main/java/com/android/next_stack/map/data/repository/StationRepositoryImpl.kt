package com.android.next_stack.map.data.repository

import com.android.next_stack.map.data.api.TidesApi
import com.android.next_stack.map.data.model.station.StationData
import com.android.next_stack.map.domain.model.station.Station
import com.android.next_stack.map.domain.repository.StationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class StationRepositoryImpl(
    private val tidesApi: TidesApi,
) : StationRepository {

    override fun getStations(): Flow<List<Station>> = flow {
        val response = tidesApi.getStations()
        emit(response.data.map { it.toDomain() })
    }.flowOn(Dispatchers.IO)

    private fun StationData.toDomain(): Station {
        return Station(
            id = id,
            title = title,
            latitude = latitude,
            longitude = longitude
        )
    }
}
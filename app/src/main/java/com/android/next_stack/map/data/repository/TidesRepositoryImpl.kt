package com.android.next_stack.map.data.repository

import com.android.next_stack.map.data.api.TidesApi
import com.android.next_stack.map.data.mapper.TideMapper
import com.android.next_stack.map.domain.model.tides.Tide
import com.android.next_stack.map.domain.repository.TidesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TidesRepositoryImpl(
    private val api: TidesApi,
    private val mapper: TideMapper,
) : TidesRepository {

    override fun getTidesExtremes(
        latitude: Double,
        longitude: Double,
        startDate: String,
        endDate: String,
        datum: String,
    ): Flow<List<Tide>> = flow {
        println("latitude: $latitude, longitude: $longitude, startDate: $startDate, endDate: $endDate, datum: $datum")
        val response = api.getTidesExtremes(latitude, longitude, startDate, endDate, datum)
        println("response: $response")
        emit(mapper.mapToDomain(response.data))
    }.flowOn(Dispatchers.IO)
}

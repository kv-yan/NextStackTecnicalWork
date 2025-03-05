package com.android.next_stack.map.domain.repository

import com.android.next_stack.map.domain.model.station.Station
import kotlinx.coroutines.flow.Flow

interface StationRepository {
    fun getStations(): Flow<List<Station>>
}
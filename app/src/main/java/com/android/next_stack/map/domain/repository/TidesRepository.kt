package com.android.next_stack.map.domain.repository

import com.android.next_stack.map.domain.model.tides.Tide
import kotlinx.coroutines.flow.Flow

interface TidesRepository {
    fun getTidesExtremes(
        latitude: Double,
        longitude: Double,
        startDate: String,
        endDate: String,
        datum: String,
    ): Flow<List<Tide>>
}
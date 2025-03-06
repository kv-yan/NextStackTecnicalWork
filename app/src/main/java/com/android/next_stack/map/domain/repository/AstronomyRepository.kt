package com.android.next_stack.map.domain.repository

import com.android.next_stack.map.domain.model.astronomy.AstronomyData
import kotlinx.coroutines.flow.Flow

interface AstronomyRepository {
    fun getAstronomyData(
        latitude: Double,
        longitude: Double,
        startDate: String,
        endDate: String,
        datum: String
    ): Flow<AstronomyData>
}
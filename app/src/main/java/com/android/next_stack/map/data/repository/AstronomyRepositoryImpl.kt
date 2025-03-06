package com.android.next_stack.map.data.repository

import com.android.next_stack.map.data.api.TidesApi
import com.android.next_stack.map.data.model.astronomy.AstronomyDataResponse
import com.android.next_stack.map.domain.model.astronomy.AstronomyData
import com.android.next_stack.map.domain.model.astronomy.MoonPhase
import com.android.next_stack.map.domain.repository.AstronomyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AstronomyRepositoryImpl(
    private val tidesApi: TidesApi
) : AstronomyRepository {

    override  fun getAstronomyData(
        latitude: Double,
        longitude: Double,
        startDate: String,
        endDate: String,
        datum: String
    ): Flow<AstronomyData> = flow {
        val response = tidesApi.getAstronomyData(latitude, longitude, startDate, endDate, datum)
        emit(response.data.first().toDomain())
    }

    private fun AstronomyDataResponse.toDomain(): AstronomyData {
        return AstronomyData(
            sunrise = sunrise,
            sunset = sunset,
            moonrise = moonrise,
            moonset = moonset,
            astronomicalDawn = astronomicalDawn,
            astronomicalDusk = astronomicalDusk,
            nauticalDawn = nauticalDawn,
            nauticalDusk = nauticalDusk,
            solarNoon = solarNoon,
            goldenHourEnd = goldenHourEnd,
            nightEnd = nightEnd,
            night = night,
            nadir = nadir,
            moonPhase = MoonPhase(
                emoji = moonFraction.emoji,
                phase = moonFraction.phase,
                value = moonFraction.value
            )
        )
    }
}
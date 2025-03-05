package com.android.next_stack.map.data.api

import com.android.next_stack.map.data.model.astronomy.AstronomyResponse
import com.android.next_stack.map.data.model.station.StationResponse
import com.android.next_stack.map.data.model.tides.TidesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TidesApi {
    @GET("api/v3/tides/extremes")
    suspend fun getTidesExtremes(
        @Query("lat") latitude: Double,
        @Query("lng") longitude: Double,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String,
        @Query("datum") datum: String,
    ): TidesResponse


    @GET("api/v1/stations/get")
    suspend fun getStations(): StationResponse

    @GET("api/v3/tides/astrology")
    suspend fun getAstronomyData(
        @Query("lat") latitude: Double,
        @Query("lng") longitude: Double,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String,
        @Query("datum") datum: String,
    ): AstronomyResponse
}

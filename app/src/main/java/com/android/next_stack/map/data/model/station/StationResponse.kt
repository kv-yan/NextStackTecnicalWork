package com.android.next_stack.map.data.model.station

data class StationResponse(
    val data: List<StationData>,
    val success: Boolean,
    val errorMessage: String,
    val code : Int
)

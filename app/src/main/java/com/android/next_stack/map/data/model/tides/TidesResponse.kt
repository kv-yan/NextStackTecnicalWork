package com.android.next_stack.map.data.model.tides

data class TidesResponse(
    val code: Int,
    val `data`: List<TideData>,
    val errorMessage: String,
    val success: Boolean
)
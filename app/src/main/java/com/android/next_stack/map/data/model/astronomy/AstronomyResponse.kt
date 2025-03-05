package com.android.next_stack.map.data.model.astronomy

data class AstronomyResponse(
    val data: List<AstronomyDataResponse>,
    val success: Boolean,
    val code: Int,
    val errorMessage: String?,
)
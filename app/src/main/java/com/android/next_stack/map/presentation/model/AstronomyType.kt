package com.android.next_stack.map.presentation.model

enum class AstronomyType {
    SUNRISE,
    SUNSET,
    MOONRISE,
    MOONSET
}

data class AstronomyItem(
    val time: String,
    val amPm: String,
    val type: AstronomyType
)
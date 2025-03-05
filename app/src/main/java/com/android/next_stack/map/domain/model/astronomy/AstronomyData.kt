package com.android.next_stack.map.domain.model.astronomy

data class AstronomyData(
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,
    val moonPhase: MoonPhase,
    val astronomicalDawn: String,
    val astronomicalDusk: String,
    val nauticalDawn: String,
    val nauticalDusk: String,
    val solarNoon: String,
    val goldenHourEnd: String,
    val nightEnd: String,
    val night: String,
    val nadir: String,
)

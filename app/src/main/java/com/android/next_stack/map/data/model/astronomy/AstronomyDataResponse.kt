package com.android.next_stack.map.data.model.astronomy

data class AstronomyDataResponse(
    val astronomicalDawn: String,
    val astronomicalDusk: String,
    val moonFraction: MoonFraction,
    val moonrise: String,
    val moonset: String,
    val nauticalDawn: String,
    val nauticalDusk: String,
    val sunrise: String,
    val sunset: String,
    val nightEnd: String,
    val night: String,
    val goldenHourEnd: String,
    val solarNoon: String,
    val nadir: String,
    val time: String
)

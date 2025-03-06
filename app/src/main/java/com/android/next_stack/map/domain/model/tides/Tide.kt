package com.android.next_stack.map.domain.model.tides

data class Tide(
    val height: String,
    val time: String,
    val amPm: String,
    val type: String, // "high" or "low"
    val image: Int = 0 // Default value, will be mapped in the mapper
)
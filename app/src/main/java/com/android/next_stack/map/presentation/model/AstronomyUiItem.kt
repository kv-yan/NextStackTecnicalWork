package com.android.next_stack.map.presentation.model

data class AstronomyUiItem(
    val time: String,
    val amPm: String,
    val type: AstronomyUIType,
    val high: String = "",
)
package com.android.next_stack.map.domain.ext

import com.android.next_stack.map.domain.model.astronomy.AstronomyData
import com.android.next_stack.map.presentation.model.AstronomyUIType
import com.android.next_stack.map.presentation.model.AstronomyUiItem
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun AstronomyData.getAsList(): List<AstronomyUiItem> {
    val astronomyList = mutableListOf<AstronomyUiItem>()

    fun formatTime(dateTime: String): Pair<String, String> {
        val time = LocalTime.parse(dateTime.substring(11), DateTimeFormatter.ofPattern("HH:mm:ss"))
        val amPm = if (time.hour < 12) "AM" else "PM"
        return time.format(DateTimeFormatter.ofPattern("hh:mm")) to amPm
    }

    listOf(
        sunrise to AstronomyUIType.SUNRISE,
        moonrise to AstronomyUIType.MOONRISE,
        sunset to AstronomyUIType.SUNSET,
        moonset to AstronomyUIType.MOONSET
    ).forEach { (timeString, type) ->
        val (formattedTime, amPm) = formatTime(timeString)
        astronomyList.add(AstronomyUiItem(time = formattedTime, amPm = amPm, type = type, high = this.sunset))
    }

    return astronomyList
}

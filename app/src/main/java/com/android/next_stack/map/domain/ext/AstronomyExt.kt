package com.android.next_stack.map.domain.ext

import android.os.Build
import androidx.annotation.RequiresApi
import com.android.next_stack.map.domain.model.astronomy.AstronomyData
import com.android.next_stack.map.presentation.model.AstronomyItem
import com.android.next_stack.map.presentation.model.AstronomyType

import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun AstronomyData.getAsList(): List<AstronomyItem> {
    val astronomyList = mutableListOf<AstronomyItem>()

    fun formatTime(dateTime: String): Pair<String, String> {
        val time = LocalTime.parse(dateTime.substring(11), DateTimeFormatter.ofPattern("HH:mm:ss"))
        val amPm = if (time.hour < 12) "AM" else "PM"
        return time.format(DateTimeFormatter.ofPattern("hh:mm")) to amPm
    }

    listOf(
        sunrise to AstronomyType.SUNRISE,
        moonrise to AstronomyType.MOONRISE,
        sunset to AstronomyType.SUNSET,
        moonset to AstronomyType.MOONSET
    ).forEach { (timeString, type) ->
        val (formattedTime, amPm) = formatTime(timeString)
        astronomyList.add(AstronomyItem(formattedTime, amPm, type))
    }

    return astronomyList
}

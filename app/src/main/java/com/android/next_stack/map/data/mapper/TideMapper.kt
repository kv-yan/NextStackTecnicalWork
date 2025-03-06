package com.android.next_stack.map.data.mapper

import com.android.next_stack.R
import com.android.next_stack.map.data.model.tides.TideData
import com.android.next_stack.map.domain.model.tides.Tide
import java.text.SimpleDateFormat
import java.util.Locale


class TideMapper {
    fun mapToDomain(data: List<TideData>): List<Tide> {
        return data.map { tideData ->
            val (formattedTime, amPm) = convertTime(tideData.time)
            Tide(
                height = tideData.height.toString(),
                time = formattedTime,
                amPm = amPm,
                type = tideData.type,
                image = when (tideData.type.lowercase()) {
                    "low" -> R.drawable.ic_low
                    "high" -> R.drawable.ic_high
                    else -> 0 // Default icon
                }
            )
        }
    }

    private fun convertTime(rawTime: String): Pair<String, String> {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)
        val outputFormat = SimpleDateFormat("hh:mm", Locale.US)
        val amPmFormat = SimpleDateFormat("a", Locale.US) // AM/PM format

        return try {
            val date = inputFormat.parse(rawTime) ?: return Pair("", "")
            Pair(outputFormat.format(date), amPmFormat.format(date))
        } catch (e: Exception) {
            e.printStackTrace()
            Pair("", "")
        }
    }
}
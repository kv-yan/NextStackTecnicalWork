package com.android.next_stack.map.data.mapper

import com.android.next_stack.R
import com.android.next_stack.map.data.model.tides.TideData
import com.android.next_stack.map.domain.model.tides.Tide

class TideMapper {
    fun mapToDomain(data: List<TideData>): List<Tide> {
        return data.map { tideData ->
            Tide(
                height = tideData.height.toString(),
                time = tideData.time,
                type = tideData.type,
                image = when (tideData.type.lowercase()) {
                    "low" -> R.drawable.ic_low
                    "high" -> R.drawable.ic_high
                    else -> 0 // Default icon
                }
            )
        }
    }
}

package com.android.next_stack.map.presentation

import com.android.next_stack.map.domain.model.tides.Tide
import com.google.android.gms.maps.model.LatLng

data class ScreenState(
    val selectedPosition: LatLng? = null,
    val selectedStationName: String? = null,
    val tidesExtremesResponse: List<Tide>? = null,
    val astronomyResponse: String? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)

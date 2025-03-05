package com.android.next_stack.map.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.next_stack.map.domain.model.station.Station
import com.android.next_stack.map.domain.usecase.GetAstronomyDataUseCase
import com.android.next_stack.map.domain.usecase.GetStationUseCase
import com.android.next_stack.map.domain.usecase.GetTidesExtremesUseCase
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update


class StationViewModel(
    private val getTidesExtremesUseCase: GetTidesExtremesUseCase,
    private val getStationUseCase: GetStationUseCase,
    private val getAstronomyDataUseCase: GetAstronomyDataUseCase,
) : ViewModel() {

    // State to manage UI
    private val _screenState = MutableStateFlow(ScreenState())
    val screenState: StateFlow<ScreenState> get() = _screenState

    // Stations list
    private val _stations = MutableStateFlow<List<Station>>(emptyList())
    val stations: StateFlow<List<Station>> get() = _stations

    init {
        fetchStations()
    }

    // Function to fetch Tides Extremes and Astronomy Data
    fun fetchDataForPosition(latitude: Double, longitude: Double, stationName: String) {
        _screenState.update {
            it.copy(
                selectedPosition = LatLng(latitude, longitude),
                selectedStationName = stationName, // Update selected station name
                isLoading = true,
                error = null
            )
        }


        getTidesExtremesUseCase.invoke(
            latitude = latitude,
            longitude = longitude,
            startDate = "20250219", // Use YYYYMMDD format
            endDate = "20250219",   // Use YYYYMMDD format
            datum = "msl"
        ).onEach { flow ->
            _screenState.update {
                it.copy(
                    tidesExtremesResponse = flow,
                    isLoading = false,
                    error = null
                )
            }
        }.catch { throwable ->
            _screenState.update {
                it.copy(
                    error = "Error: ${throwable.message}",
                    isLoading = false
                )
            }
        }.launchIn(viewModelScope)
        // Fetch Astronomy Data
        getAstronomyDataUseCase.invoke(
            latitude = latitude,
            longitude = longitude,
            startDate = "2023-10-01", // Replace with dynamic dates if needed
            endDate = "2023-10-07", // Replace with dynamic dates if needed
            datum = "msl"
        ).onEach {
            _screenState.value = _screenState.value.copy(astronomyResponse = it, isLoading = false)
        }.catch { throwable ->
            _screenState.value = _screenState.value.copy(error = "Error: ${throwable.message}")
        }.launchIn(viewModelScope)
    }

    private fun fetchStations() {
        getStationUseCase.invoke().onEach {
            _stations.value = it
        }.catch { throwable ->
            _screenState.value = _screenState.value.copy(error = "Error: ${throwable.message}")
        }.launchIn(viewModelScope)

    }

    // Reset state when dialog is dismissed
    fun resetState() {
        _screenState.update { ScreenState() }
    }
}
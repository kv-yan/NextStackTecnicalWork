package com.android.next_stack.map.presentation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.android.next_stack.map.presentation.component.AstronomySection
import com.android.next_stack.map.presentation.component.MapHeader
import com.android.next_stack.map.presentation.component.StationMap
import com.android.next_stack.map.presentation.component.TideSection
import org.koin.androidx.compose.koinViewModel


@Composable
fun MapScreen(
    viewModel: StationViewModel = koinViewModel(),
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    val screenState by viewModel.screenState.collectAsState()
    val stations by viewModel.stations.collectAsState()
    val context = LocalContext.current

    BackHandler {
        if (screenState.selectedStationName != null) {
            viewModel.resetState()
        } else {
            // Allow system back press behavior
            val activity = (context as? Activity)
            activity?.onBackPressed()
        }
    }


    Box(modifier = modifier.fillMaxSize()) {
        // Display the map
        StationMap(
            stations = stations,
            onMarkerClick = { latitude, longitude, stationName ->
                viewModel.fetchDataForPosition(latitude, longitude, stationName)
            }
        )
        if (screenState.selectedStationName != null) {
            // Display the selected station data
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFF121E3B), Color(0xFF1E293B))
                        ), shape = RoundedCornerShape(16.dp)
                    )
                    .verticalScroll(scrollState)
                    .align(Alignment.BottomCenter)
            ) {

                MapHeader(screenState = screenState)
                Spacer(modifier = Modifier.height(8.dp))
                if (screenState.isLoading) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    AstronomySection(screenState)
                    TideSection(screenState = screenState)
                }
                if (screenState.error != null) {
                    Text(text = screenState.error ?: "Something went wrong", color = Color.Red)
                }
            }
        }
    }
}


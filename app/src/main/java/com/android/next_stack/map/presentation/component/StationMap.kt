package com.android.next_stack.map.presentation.component


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.android.next_stack.R
import com.android.next_stack.map.domain.model.station.Station
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.clustering.ClusterManager

@Composable
fun StationMap(
    modifier: Modifier = Modifier,
    stations: List<Station>,
    onMarkerClick: (Double, Double, String) -> Unit,
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    // State to hold the GoogleMap object
    var googleMap by remember { mutableStateOf<GoogleMap?>(null) }

    // State to hold the ClusterManager
    var clusterManager by remember { mutableStateOf<ClusterManager<StationClusterItem>?>(null) }

    // Load custom map style from raw resource
    val mapStyle = remember {
        context.resources.openRawResource(R.raw.map_style)
            .bufferedReader()
            .use { it.readText() }
    }

    val mapView = remember {
        MapView(context).apply {
            onCreate(null)
            getMapAsync { map ->
                googleMap = map
                // Applying custom map style
                map.setMapStyle(MapStyleOptions(mapStyle))

                // Initializeing ClusterManager with custom renderer
                clusterManager = ClusterManager<StationClusterItem>(context, map).apply {
                    setRenderer(
                        CustomClusterRenderer( // Useed the simplified renderer
                            context,
                            map,
                            this
                        )
                    )

                    // Set click listener for markers
                    setOnClusterItemClickListener { item ->
                        // Get the clicked marker's latitude, longitude, and name
                        val latitude = item.position.latitude
                        val longitude = item.position.longitude
                        val stationName = item.title

                        // Call the lambda to handle the click
                        onMarkerClick(latitude, longitude, stationName)
                        true // Return true to indicate the event is consumed
                    }
                }
                map.setOnCameraIdleListener(clusterManager)
            }
        }
    }

    // Handle lifecycle events
    DisposableEffect(lifecycleOwner) {
        val observer = object : DefaultLifecycleObserver {
            override fun onResume(owner: LifecycleOwner) {
                mapView.onResume()
            }

            override fun onPause(owner: LifecycleOwner) {
                mapView.onPause()
            }

            override fun onDestroy(owner: LifecycleOwner) {
                mapView.onDestroy()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    // Display the MapView
    AndroidView(
        factory = { mapView },
        modifier = modifier.fillMaxSize()
    )

    // Update clusters when stations change
    LaunchedEffect(stations) {
        clusterManager?.clearItems()
        stations.forEach { station ->
            clusterManager?.addItem(
                StationClusterItem(
                    LatLng(station.latitude, station.longitude),
                    station.title
                )
            )
        }
        clusterManager?.cluster()
    }
}

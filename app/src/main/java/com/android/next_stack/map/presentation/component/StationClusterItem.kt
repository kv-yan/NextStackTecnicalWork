package com.android.next_stack.map.presentation.component


import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem


class StationClusterItem(
    private val position: LatLng, // Use override val
    private val title: String,
    private val snippet: String = "",
) : ClusterItem {
    override fun getPosition(): LatLng {
        return position
    }

    override fun getTitle(): String {
        return title
    }

    override fun getSnippet(): String {
        return snippet
    }
}
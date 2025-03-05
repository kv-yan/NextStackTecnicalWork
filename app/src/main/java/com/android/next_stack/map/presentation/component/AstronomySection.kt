package com.android.next_stack.map.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android.next_stack.map.domain.ext.getAsList
import com.android.next_stack.map.presentation.ScreenState
import com.android.next_stack.map.presentation.items.AstronomyElement

@Composable
fun AstronomySection(screenState: ScreenState) {
    val astronomyList = screenState.astronomyResponse?.getAsList()
    if (astronomyList != null) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            astronomyList.forEach {
                AstronomyElement(astronomyItem = it)
            }
        }
    }
}


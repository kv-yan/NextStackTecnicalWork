package com.android.next_stack.map.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.next_stack.map.domain.ext.getAsList
import com.android.next_stack.map.presentation.ScreenState
import com.android.next_stack.map.presentation.items.AstronomyElement

@Composable
fun AstronomySection(screenState: ScreenState) {
    val astronomyList = screenState.astronomyResponse?.getAsList()
    if (astronomyList != null) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                astronomyList.forEach {
                    AstronomyElement(astronomyUiItem = it)
                }
            }

            AstronomyWave(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                astronomyList = astronomyList
            )
        }
    }
}


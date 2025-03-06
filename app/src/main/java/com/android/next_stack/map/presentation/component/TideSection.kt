package com.android.next_stack.map.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.next_stack.map.presentation.ScreenState
import com.android.next_stack.map.presentation.items.TideItem

@Composable
fun TideSection(modifier: Modifier = Modifier, screenState: ScreenState) {
    if (screenState.tidesExtremesResponse.isNullOrEmpty()) {
        Text(text = "No tides data available")
    } else {
        val tides = screenState.tidesExtremesResponse
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .heightIn(0.dp, 250.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(tides) { index, item ->
                TideItem(
                    modifier = Modifier.fillMaxWidth(),
                    item = item,
                    isShowingDivider = index != tides.lastIndex
                )
            }
        }
    }
}
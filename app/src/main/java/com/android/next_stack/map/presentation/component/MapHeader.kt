package com.android.next_stack.map.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.next_stack.R
import com.android.next_stack.common_presentation.ui.theme.MainTextColor
import com.android.next_stack.map.presentation.ScreenState

@Composable
fun MapHeader(modifier: Modifier = Modifier, screenState: ScreenState) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_location),
            contentDescription = null,
            tint = MainTextColor
        )

        Text(
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f),
            text = screenState.selectedStationName ?: "Error",
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.proximanova_blackit)),
            color = MainTextColor
        )

        Icon(
            painter = painterResource(R.drawable.ic_favorite),
            contentDescription = null,
            tint = MainTextColor
        )
    }
}
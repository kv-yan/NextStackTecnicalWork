package com.android.next_stack.map.presentation.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.next_stack.R
import com.android.next_stack.common_presentation.ui.theme.MainTextColor
import com.android.next_stack.map.presentation.model.AstronomyUiItem
import com.android.next_stack.map.presentation.model.AstronomyUIType

@Composable
fun AstronomyElement(modifier: Modifier = Modifier, astronomyUiItem: AstronomyUiItem) {
    val image = when (astronomyUiItem.type) {
        AstronomyUIType.SUNRISE -> R.drawable.ic_sunrise
        AstronomyUIType.SUNSET -> R.drawable.ic_sunset
        AstronomyUIType.MOONRISE -> R.drawable.ic_moonrise
        AstronomyUIType.MOONSET -> R.drawable.ic_moonset
    }
    Row(
        modifier = modifier.padding(horizontal = 2.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(image),
            contentDescription = null,
        )

        Text(
            modifier = modifier,
            text = astronomyUiItem.time,
            color = MainTextColor,
            fontFamily = FontFamily(Font(R.font.roboto_condensed_bold)),
            fontSize = 14.sp
        )
        Text(
            modifier = modifier,
            text = astronomyUiItem.amPm,
            color = MainTextColor,
            fontFamily = FontFamily(Font(R.font.roboto_condensed_bold)),
            fontSize = 12.sp
        )

    }
}
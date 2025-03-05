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
import com.android.next_stack.map.presentation.model.AstronomyItem
import com.android.next_stack.map.presentation.model.AstronomyType

@Composable
fun AstronomyElement(modifier: Modifier = Modifier, astronomyItem: AstronomyItem) {
    val image = when (astronomyItem.type) {
        AstronomyType.SUNRISE -> R.drawable.ic_sunrise
        AstronomyType.SUNSET -> R.drawable.ic_sunset
        AstronomyType.MOONRISE -> R.drawable.ic_moonrise
        AstronomyType.MOONSET -> R.drawable.ic_moonset
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
            text = astronomyItem.time,
            color = MainTextColor,
            fontFamily = FontFamily(Font(R.font.roboto_condensed_bold)),
            fontSize = 14.sp
        )
        Text(
            modifier = modifier,
            text = astronomyItem.amPm,
            color = MainTextColor,
            fontFamily = FontFamily(Font(R.font.roboto_condensed_bold)),
            fontSize = 12.sp
        )

    }
}
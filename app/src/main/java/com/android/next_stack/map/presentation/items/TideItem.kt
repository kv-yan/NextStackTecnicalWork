package com.android.next_stack.map.presentation.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.next_stack.R
import com.android.next_stack.common_presentation.ui.theme.MainTextColor
import com.android.next_stack.map.domain.model.tides.Tide

@Composable
fun TideItem(modifier: Modifier = Modifier, item: Tide, isShowingDivider: Boolean = true) {
    Column(modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = null,
                )

                Text(
                    text = item.type,
                    color = MainTextColor,
                    fontFamily = FontFamily(Font(R.font.roboto_serif_thin)),
                    fontSize = 15.sp
                )
            }

            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.Center
            ) {
                Text(
                    text = item.time,
                    color = MainTextColor,
                    fontFamily = FontFamily(Font(R.font.roboto_condensed_bold)),
                    fontSize = 16.sp
                )

                Text(
                    text = item.amPm,
                    color = MainTextColor,
                    fontFamily = FontFamily(Font(R.font.roboto_serif_thin)),
                    fontSize = 15.sp
                )
            }

            Text(
                modifier = Modifier.weight(1f),
                text = "${item.height} ft.",
                color = MainTextColor,
                fontFamily = FontFamily(Font(R.font.roboto_condensed_bold)),
                fontSize = 15.sp,
                textAlign = TextAlign.End
            )
        }
        if (isShowingDivider)
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF36455D),
                thickness = 1.dp
            )
    }
}
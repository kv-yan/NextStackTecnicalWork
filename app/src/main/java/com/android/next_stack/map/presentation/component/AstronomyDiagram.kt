package com.android.next_stack.map.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.next_stack.R
import com.android.next_stack.common_presentation.ui.theme.MainTextColor
import com.android.next_stack.map.presentation.model.AstronomyUiItem

@Composable
fun AstronomyWave(
    modifier: Modifier = Modifier,
    astronomyList: List<AstronomyUiItem>,
) {
    Box(
        modifier = modifier
            .height(94.dp)
            .fillMaxWidth()
    ) {

        Image(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(84.dp),
            painter = painterResource(id = R.drawable.astronomy_diagram),
            contentDescription = "Wave",

            )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .align(Alignment.TopCenter),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            AstronomyElement(
                modifier = Modifier.absoluteOffset(
                    0.dp,
                    28.dp
                ), astronomyUiItem = astronomyList[0]
            )
            AstronomyElement(
                modifier = Modifier.absoluteOffset(
                    (-18).dp,
                    1.dp
                ), astronomyUiItem = astronomyList[1]
            )
            AstronomyElement(
                modifier = Modifier.absoluteOffset(
                    0.dp,
                    24.dp
                ), astronomyUiItem = astronomyList[2]
            )
            AstronomyElement(
                modifier = Modifier.absoluteOffset(
                    (-18).dp,
                    8.dp
                ), astronomyUiItem = astronomyList[3]
            )
        }
    }
}

@Composable
fun AstronomyElement(
    modifier: Modifier = Modifier,
    astronomyUiItem: AstronomyUiItem,
) {

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = astronomyUiItem.time,
            color = MainTextColor,
            fontFamily = FontFamily(Font(R.font.roboto_condensed_bold)),
            fontSize = 16.sp
        )

        Spacer(
            modifier = Modifier
                .background(Color(0xFF5990FF), CircleShape)
                .padding(2.dp)
                .background(Color.White, CircleShape)
                .size(8.dp)
        )

        Text(
            text = astronomyUiItem.time,
            color = Color(0xFF9499A0),
            fontFamily = FontFamily(Font(R.font.roboto_condensed_bold)),
            fontSize = 16.sp
        )
    }
}
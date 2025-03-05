package com.android.next_stack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import com.android.next_stack.common_presentation.ui.theme.NextStackTecnicalWorkTheme
import com.android.next_stack.map.presentation.MapScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NextStackTecnicalWorkTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.setStatusBarColor(Color.Transparent, darkIcons = false)
                MapScreen()
            }
        }
    }
}
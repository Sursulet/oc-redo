package com.sursulet.realestatemanager.presentation

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sursulet.realestatemanager.domain.windowmetrics.WindowMetrics
import com.sursulet.realestatemanager.domain.windowmetrics.rememberWindowSizeType
import com.sursulet.realestatemanager.presentation.ui.theme.RealEstateManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealEstateManagerTheme {
                val windowSizeType = rememberWindowSizeType()
                if (windowSizeType.screenWidthInfo != WindowMetrics.WindowSizeType.Compact) {
                    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                }

                RealEstateManagerApp(widthSizeType = windowSizeType.screenWidthInfo)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RealEstateManagerTheme {
        RealEstateManagerApp(widthSizeType = WindowMetrics.WindowSizeType.Compact)
    }
}
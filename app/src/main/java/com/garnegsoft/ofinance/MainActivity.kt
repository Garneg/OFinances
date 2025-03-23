package com.garnegsoft.ofinance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.garnegsoft.ofinance.ui.navigation.AppNavigationGraph
import com.garnegsoft.ofinance.ui.theme.CashuallyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CashuallyTheme {
                AppNavigationGraph()
            }
        }
    }
}

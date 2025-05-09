package com.example.baitaplaptrinhdidong

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.baitaplaptrinhdidong.navHost.AppNavigation
import com.example.baitaplaptrinhdidong.ui.features.week6.Week6Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            AppNavigation()
            Week6Navigation()
        }
    }
}

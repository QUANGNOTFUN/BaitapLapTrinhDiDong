package com.example.baitaplaptrinhdidong.ui.features.week2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.baitap.screens.components.LazyButtonNav
import com.example.baitaplaptrinhdidong.ui.base.BaseScreen

@Composable
fun Week2(navController: NavController) {
    BaseScreen(
        "Tuần 2",
        true,
        onBackClick = { navController.popBackStack() }
    ) { padding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopCenter)
                .padding(padding)
        ) {
            LazyButtonNav(navController, 2, "Bài", "w2_exercise")
        }

    }
}
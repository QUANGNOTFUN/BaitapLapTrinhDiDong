package com.example.baitap.screens.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ButtonBackScreen(navController: NavHostController) {
    IconButton(
        onClick = {navController.popBackStack()},
        modifier = Modifier.padding(10.dp)
    ) {
        Icon(Icons.Filled.ArrowBack, contentDescription = null)
    }
}
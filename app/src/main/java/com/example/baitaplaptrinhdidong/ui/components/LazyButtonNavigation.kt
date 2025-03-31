package com.example.baitap.screens.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LazyButtonNav(navController: NavController, size: Int, nameBtnLabel: String, nameScreen: String) {
    val buttonLabels = (1..size).map {"${nameBtnLabel} ${it}"}

    LazyColumn(Modifier.padding(16.dp)) {
        items(buttonLabels) { label ->
            Button(
                onClick = {navController.navigate("${nameScreen}_${label.last()}")},
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(label)
            }
        }
    }
}
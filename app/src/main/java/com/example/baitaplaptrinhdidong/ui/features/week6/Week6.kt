package com.example.baitaplaptrinhdidong.ui.features.week6

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Week6Navigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val viewModel: W6ViewModel = viewModel(factory = W6ListViewModelFactory(context))

    NavHost(navController = navController, startDestination = "w6_list_screen") {
        composable("w6_list_screen") {
            W6_ListScreen(navController = navController, viewModel = viewModel)
        }
        composable("w6_add_screen") {
            W6_AddScreen(navController = navController, viewModel = viewModel)
        }
    }
}
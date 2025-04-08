package com.example.baitaplaptrinhdidong.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.baitap.screens.MainScreen
import com.example.baitaplaptrinhdidong.ui.features.week2.exercise.W2_Exercise1
import com.example.baitaplaptrinhdidong.ui.features.week2.exercise.W2_Exercise2
import com.example.baitaplaptrinhdidong.ui.features.week3.exercise.W3_Ex1_Page1
import com.example.baitaplaptrinhdidong.ui.features.week3.exercise.W3_Ex1_Page2
import com.example.baitaplaptrinhdidong.ui.features.week3.exercise.W3_Ex2_Page1
import com.example.baitaplaptrinhdidong.ui.features.week3.exercise.W3_Ex2_Page2
import com.example.baitaplaptrinhdidong.ui.features.week3.exercise.W3_Ex2_Page3
import com.example.baitaplaptrinhdidong.ui.features.week3.exercise.W3_Exercise1
import com.example.baitaplaptrinhdidong.ui.features.week3.exercise.W3_Exercise2
import com.example.baitaplaptrinhdidong.ui.features.week4.exercise.W4_Ex1_Page1
import com.example.baitaplaptrinhdidong.ui.features.week4.exercise.W4_Ex1_Page2
import com.example.baitaplaptrinhdidong.ui.features.week4.exercise.W4_Ex1_Page3
import com.example.baitaplaptrinhdidong.ui.features.week4.exercise.W4_Ex2_Page1
import com.example.baitaplaptrinhdidong.ui.features.week4.exercise.W4_Ex2_Page2
import com.example.baitaplaptrinhdidong.ui.features.week4.exercise.W4_Exercise1
import com.example.baitaplaptrinhdidong.ui.features.week4.exercise.W4_Exercise2
import com.example.baitaplaptrinhdidong.ui.features.week1.Week1
import com.example.baitaplaptrinhdidong.ui.features.week2.Week2
import com.example.baitaplaptrinhdidong.ui.features.week3.Week3
import com.example.baitaplaptrinhdidong.ui.features.week4.Week4
import com.example.baitaplaptrinhdidong.ui.features.week5.Week5
import com.example.baitaplaptrinhdidong.ui.features.week5.detail.W5_InfoUserScreen
import com.example.baitaplaptrinhdidong.ui.features.week6.W6_AddScreen
import com.example.baitaplaptrinhdidong.ui.features.week6.W6_ListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { MainScreen(navController) }
        // Tuàn 1
        composable("week_1") { Week1(navController) }
        // Tuần 2
        composable("week_2") { Week2(navController) }
            // Ex1
            composable("w2_exercise_1") { W2_Exercise1(navController) }
            // Ex2
            composable("w2_exercise_2") { W2_Exercise2(navController) }
        // Tuần 3
        composable("week_3") { Week3(navController) }
            // Ex1
            composable("w3_exercise_1") { W3_Exercise1(navController) }
                composable("w3_ex1_page_1") { W3_Ex1_Page1(navController) }
                composable("w3_ex1_page_2") { W3_Ex1_Page2(navController) }
            // Ex2
            composable("w3_exercise_2") { W3_Exercise2(navController) }
                composable("w3_ex2_page_1") { W3_Ex2_Page1(navController) }
                composable("w3_ex2_page_2") { W3_Ex2_Page2(navController) }
                composable("w3_ex2_page_3") { W3_Ex2_Page3(navController) }
        // Tuần 4
        composable("week_4") { Week4(navController) }
            // Ex1
            composable("w4_exercise_1") { W4_Exercise1(navController) }
                composable("w4_ex1_page_1") { W4_Ex1_Page1(navController) }
                composable("w4_ex1_page_2") { W4_Ex1_Page2(navController) }
                composable("w4_ex1_page_3") { W4_Ex1_Page3(navController) }
            // Ex2
            composable("w4_exercise_2") { W4_Exercise2(navController) }
                composable("w4_ex2_page_1") { W4_Ex2_Page1(navController) }
                composable("w4_ex2_page_2/{query}") { backStackEntry ->
                    val query = backStackEntry.arguments?.getString("query")?.toIntOrNull() ?: 0
                    W4_Ex2_Page2(navController, query)
                }
        // Tuần 5
        composable("week_5") { Week5(navController) }
            composable("w5_info_user") { W5_InfoUserScreen(navController) }

        // Tuần 6
//        composable("week_6") { W6_ListScreen(navController) }
//            composable("w6_add_screen") { W6_AddScreen(navController) }
    }
}

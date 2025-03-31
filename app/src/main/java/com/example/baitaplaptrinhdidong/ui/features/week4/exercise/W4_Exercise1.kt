package com.example.baitaplaptrinhdidong.ui.features.week4.exercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.ui.base.BaseScreen

@Composable
fun W4_Exercise1(navController: NavController) {
    W4_Ex1_Page1(navController)
}

@Composable
fun W4_Ex1_Page1(navController: NavController) {
    BaseScreen { padding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.w3bai1),
                contentDescription = "Icon",
                modifier = Modifier.fillMaxWidth().size(250.dp)
            )

            Spacer(Modifier.height(20.dp))
            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Navigation", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                Spacer(Modifier.height(20.dp))

                Text("is a framework that simplifies the implementation of navigation between different UI components (activities, fragments, or composables) in a app",
                    textAlign = TextAlign.Center, fontSize = 16.sp, color = Color.Gray
                )
            }

            Spacer(Modifier.height(60.dp))

            Button(onClick = { navController.navigate("w4_ex1_page_2")},
                modifier = Modifier.fillMaxWidth(0.8f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4))
            ) {
                Text("PUSH", fontSize = 20.sp)
            }
        }
    }

}

@Composable
fun W4_Ex1_Page2(navController: NavController) {
    BaseScreen (
        actionsTop = {
            Spacer(Modifier.width(10.dp))

            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.size(40.dp).padding(horizontal = 2.dp),
                colors = IconButtonDefaults.iconButtonColors(Color(0xFF03A9F4))
            ) {
                Icon( imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "BtnBack",
                    modifier = Modifier.size(30.dp),
                    tint = Color.White)
            }

            Spacer(Modifier.weight(1f))

            Text("LazyColumn", fontWeight = FontWeight.Bold, fontSize = 24.sp, color = Color(0xFF03A9F4), modifier = Modifier.weight(3f))
            Spacer(Modifier.weight(1f))
        }
    ) { padding ->
        Column (
            modifier = Modifier.fillMaxSize()
                .padding(padding).padding(10.dp)
        ) {
            val message = "The only way to do great work is to love what you do"
            val listItems = List(1000000) { index -> "$index | $message" }
            W4_Ex1_Section1(navController, listItems)
        }
    }
}

@Composable
fun W4_Ex1_Section1(navController: NavController, messages: List<String>) {
    LazyColumn {
        items(messages) { message ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = message, fontSize = 18.sp,
                        modifier = Modifier.weight(8f).padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )

                    IconButton(
                        onClick = { navController.navigate("w4_ex1_page_3") },
                        modifier = Modifier.size(40.dp).padding(horizontal = 2.dp),
                        colors = IconButtonDefaults.iconButtonColors(Color(0xFF5693AF))
                    ) {
                        Icon( imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "BtnBack",
                            modifier = Modifier.size(30.dp),
                            tint = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun W4_Ex1_Page3(navController: NavController) {
    BaseScreen (
        actionsTop = {
            Spacer(Modifier.width(10.dp))

            IconButton(
                onClick = {navController.popBackStack()},
                modifier = Modifier.size(40.dp).padding(horizontal = 2.dp),
                colors = IconButtonDefaults.iconButtonColors(Color(0xFF03A9F4))
            ) {
                Icon( imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "BtnBack",
                    modifier = Modifier.size(30.dp),
                    tint = Color.White)
            }

            Spacer(Modifier.weight(0.6f))

            Text("Detail", textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 24.sp, color = Color(0xFF03A9F4), modifier = Modifier.weight(3f))
            Spacer(Modifier.weight(1f))
        }
    ) { padding ->
        Column (
            modifier = Modifier.fillMaxSize()
                .padding(padding).padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            val message = "The only way to do great work is to love what you do"
            Text(message, fontSize = 20.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(0.7f))

            Image(
                painter = painterResource(R.drawable.w4bai1),
                contentDescription = "Image",
                modifier = Modifier.size(400.dp)
            )

            Button(onClick = { navController.navigate("w4_ex1_page_1")},
                modifier = Modifier.fillMaxWidth(0.8f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4))
            ) {
                Text("BACK TO ROOT", fontSize = 20.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prev112() {
    W4_Exercise1(navController = rememberNavController())
}
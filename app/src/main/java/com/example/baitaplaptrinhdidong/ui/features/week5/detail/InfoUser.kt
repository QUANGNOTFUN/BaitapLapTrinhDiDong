package com.example.baitaplaptrinhdidong.ui.features.week5.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.ui.base.BaseScreen

@Composable
fun W5_InfoUserScreen(navController: NavController) {
    BaseScreen(
        actionsTop = {
            IconButton(
                onClick = { navController.popBackStack()},
                Modifier.weight(1f).padding(10.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Back",
                    modifier = Modifier.size(100.dp)
                )
            }

            Text("Profile", fontSize = 32.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFF54ACDC),
                modifier = Modifier.weight(9f)
                    .wrapContentWidth(),
            )
        },
        actionsBot = {
            Button(onClick = { navController.popBackStack()},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4))
            ) {
                Text("Back", fontSize = 20.sp)
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            W5_Avatar()
            W5_SectionInfo()
        }
    }
}

@Composable
fun W5_Avatar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier.size(210.dp, 200.dp),
        ) {
            Card(
                modifier = Modifier
                    .background(Color.White)
                    .border(2.dp, Color(0xFFBE9FE7), CircleShape)
                    .align(Alignment.Center)
                    .padding(1.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_w5_avatar),
                    contentDescription = "Avatar",
                    modifier = Modifier.size(200.dp)
                        .background(Color.White)
                        .border(2.dp, Color(0xFFBE9FE7), CircleShape)
                )
            }

            Image(
                painter = painterResource(R.drawable.ic_camera),
                contentDescription = "Icon camera",
                modifier = Modifier.size(35.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}

sealed class W5_Info(val title: String, val description: String) {
    data object Name: W5_Info("Name", "Phạm Đăng Quang")
    data object Email: W5_Info("Email", "william.a.wheeler@example-pet-store.com")
    data object Phone: W5_Info("Date of Birth", "04/10/2004")
}

val listInfo = listOf(W5_Info.Name, W5_Info.Email, W5_Info.Phone)
@Composable
fun W5_SectionInfo() {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        listInfo.forEach {
            Text(it.title,
                fontWeight = FontWeight.Bold, fontSize = 26.sp,
                modifier = Modifier.padding(0.dp, 10.dp)
            )

            OutlinedTextField(
                value = it.description,
                onValueChange = {},
                readOnly = true,
                suffix = {
                    if (it.title == "Date of Birth")
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Expand"
                    )
                },
                modifier = Modifier.fillMaxWidth()
                    .background(Color.White),
            )

            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrevW5() {
    W5_InfoUserScreen(navController = rememberNavController())
}
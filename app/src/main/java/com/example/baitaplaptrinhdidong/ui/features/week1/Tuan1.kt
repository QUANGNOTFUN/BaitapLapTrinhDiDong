package com.example.baitaplaptrinhdidong.ui.features.week1

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.ui.base.BaseScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Week1(navController: NavController) {
    BaseScreen(
        "",
        true,
        onBackClick = { navController.popBackStack() },
        actionsTop = { IconButton(
            onClick = {}
        ) {
            Icon( imageVector = Icons.Filled.AccountBox, contentDescription = "Edit")
        } }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().wrapContentSize().padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Card(
                modifier = Modifier
                    .border(2.dp, Color.Black, RoundedCornerShape(100))
                    .clip(CircleShape)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bai1),
                    contentDescription  = "John",
                )
            }

            Text(
                " Phạm Đăng Quang",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Text(
                "Long An Province, Viet Nam",
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
        }
    }
}


package com.example.baitaplaptrinhdidong.ui.features.week6

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.ui.base.BaseScreen
import com.example.baitaplaptrinhdidong.ui.components.BackButton

@Composable
fun W6_ListScreen(
    navController: NavController,
    viewModel: W6ViewModel
) {
    val listState by viewModel.listTasks.collectAsState()

    BaseScreen(
        actionsTop = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackButton(navController)

                Spacer(Modifier.weight(1f))
                Text(
                    "List",
                    fontSize = 32.sp, fontWeight = FontWeight.Bold,
                    color = Color(0xFF40C2FD)
                )

                Spacer(Modifier.weight(1f))
                AddButton(navController)
            }
        },
        actionsBot = {
            W6_NavBar()
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color(0xFFE6EDEF))
        ) {
            items(listState) {
                W6_CardItem(it)
            }
        }
    }
}

@Composable
fun AddButton(
    navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .clickable { navController.navigate("w6_add_screen") },
        colors = CardDefaults.cardColors(Color(0xFF40C2FD))
    ) {
        Icon(
            imageVector = Icons.Filled.AddCircle,
            contentDescription = "Back Button",
            modifier = Modifier.size(50.dp),
            tint = Color.White
        )
    }
}

@Composable
fun W6_CardItem(
   task: TaskModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 20.dp, 20.dp, 0.dp),
        colors = CardDefaults.cardColors(Color(0xFF6ED1FF))
    ) {
        Text(
            text = task.task,
            fontSize = 24.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp, 20.dp, 0.dp, 0.dp),
            color = Color.Black
        )

        Text(
            text = task.description,
            fontSize = 18.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp, 15.dp, 0.dp, 30.dp),
            color = Color.Black
        )
    }
}

@Composable
fun W6_NavBar() {
    Box(
        modifier = Modifier.padding(20.dp, 0.dp)
            .fillMaxWidth().wrapContentWidth(),
    ) {
        Row(
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(30.dp)),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Back Button",
                modifier = Modifier.padding(5.dp).size(35.dp),
                tint = Color.Gray
            )
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = "Back Button",
                modifier = Modifier.size(35.dp),
                tint = Color.Gray
            )
            Icon(
                imageVector = Icons.Filled.AddCircle,
                contentDescription = "Back Button",
                modifier = Modifier.size(55.dp)
                    .offset(y= (-20).dp)
                    .clickable {  },
                tint = Color(0xFF4ABAEC)
            )
            Icon(
                painter = painterResource(R.drawable.ic_task),
                contentDescription = "Back Button",
                modifier = Modifier.size(35.dp),
                tint = Color.Gray
            )
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = "Back Button",
                modifier = Modifier.size(35.dp),
                tint = Color.Gray
            )
        }
    }
}


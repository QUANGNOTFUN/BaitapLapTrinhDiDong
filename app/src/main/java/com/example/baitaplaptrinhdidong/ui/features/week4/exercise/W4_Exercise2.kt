package com.example.baitaplaptrinhdidong.ui.features.week4.exercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.data.models.Task
import com.example.baitaplaptrinhdidong.ui.base.BaseScreen
import com.example.baitaplaptrinhdidong.ui.features.week4.TasksViewModel

@Composable
fun W4_Exercise2(navController: NavController) {
    W4_Ex2_Page1(navController)
}

@Composable
fun W4_Ex2_Page1(navController: NavController) {
    BaseScreen (
        actionsTop = {
            Spacer(Modifier.width(10.dp))
            
            Card(
                modifier = Modifier.padding(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.w4bai2), contentDescription = "Logo"
                )
            }

            Spacer(Modifier.width(10.dp))

            Column {
                Text("SmartTasks", fontWeight = FontWeight.Bold, fontSize = 24.sp,
                    color = Color(0xFF03A9F4))

                Text("A simple and efficient to-do app", fontWeight = FontWeight.Bold, fontSize = 12.sp,
                    color = Color(0xFF00BCD4)
                )
            }
            Spacer(Modifier.weight(1f))

            IconButton(
                onClick = {  },
                modifier = Modifier
                    .size(40.dp)
                    .padding(horizontal = 2.dp)
            ) {
                Icon( imageVector = Icons.Filled.Notifications, contentDescription = "BtnBack",
                    modifier = Modifier.size(30.dp),
                    tint = Color(0xFFFFC107)
                )
            }
        }
    ) { padding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(10.dp)
        ) {
            W4_Ex2_Section1(navController)
        }
    }
}

@Composable
fun W4_Ex2_Section1(navController: NavController , viewModel: TasksViewModel = viewModel()) {
    val tasks by viewModel.tasks.collectAsState()

    LazyColumn {
        items(tasks) { task ->
            var checkedState by remember { mutableStateOf(false) }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        navController.navigate("w4_ex2_page_2/${task.id}")
                    },
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = when (task.priority) {
                        "High" -> Color(0xFFFF8E8E)
                        "Medium" -> Color(0xFFEFDA9B)
                        "Low" -> Color(0xFFAAE5EE)
                        else -> Color(0xFFE0E0E0)
                    }
                )
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = checkedState,
                            onCheckedChange = { isChecked ->
                                checkedState = isChecked
                            },
                            modifier = Modifier
                                .size(40.dp)
                                .padding(horizontal = 2.dp),
                            colors = CheckboxDefaults.colors(checkedColor = Color(0xFF5693AF))
                        )
                        Column {
                            Text(
                                text = task.title, fontSize = 18.sp, fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )

                            Text(
                                text = task.description, fontSize = 16.sp,
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Status: ${task.status}", fontWeight = FontWeight.Bold, fontSize = 14.sp,
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Text(
                            text = task.createdAt, fontSize = 14.sp,
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 8.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun W4_Ex2_Page2(navController: NavController, query: Int) {
    BaseScreen (
        actionsTop = {
            Spacer(Modifier.width(10.dp))

            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .size(40.dp)
                    .padding(horizontal = 2.dp),
                colors = IconButtonDefaults.iconButtonColors(Color(0xFF03A9F4))
            ) {
                Icon( imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "BtnBack",
                    modifier = Modifier.size(30.dp),
                    tint = Color.White)
            }

            Spacer(Modifier.weight(1f))
            Text("Detail", fontWeight = FontWeight.Bold, fontSize = 24.sp,
                color = Color(0xFF03A9F4))

            Spacer(Modifier.weight(1f))

            IconButton(
                onClick = {  },
                modifier = Modifier
                    .size(40.dp)
                    .padding(horizontal = 2.dp)
            ) {
                Icon( imageVector = Icons.Filled.Delete, contentDescription = "BtnBack",
                    modifier = Modifier.size(30.dp),
                    tint = Color(0xFFFFC107)
                )
            }
        }
    ) { padding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(10.dp)
        ) {
            val viewModel: TasksViewModel = viewModel()

            LaunchedEffect(query) {
                viewModel.fetchTask(query) // Gọi API lấy task theo ID
            }

            val task by viewModel.task.collectAsState()

            W4_Ex2_Section2(task)
        }
    }
}

@Composable
fun W4_Ex2_Section2(task: Task?) {
    task?.let {
        Text(
        text = it.title, fontSize = 16.sp, fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(2.dp),
        style = MaterialTheme.typography.bodyLarge
    )
    }

    task?.let {
        Text(
        text = it.description, fontSize = 14.sp,
        modifier = Modifier.padding(2.dp),
        style = MaterialTheme.typography.bodyLarge
    )
    }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = when (task?.priority) {
                "High" -> Color(0xFFFF8E8E)
                "Medium" -> Color(0xFFEFDA9B)
                "Low" -> Color(0xFFAAE5EE)
                else -> Color(0xFFE0E0E0)
            }
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            val listTitle = listOf("Category", "Status", "Priority")

            listTitle.forEach {
                Icon(
                     imageVector = when (it) {
                        "Category" -> Icons.Default.ShoppingCart
                        "Status" -> Icons.Default.Settings
                        "Priority" -> Icons.Default.Star
                        else -> Icons.Default.Add // ✅ Icon mặc định
                    }
                    , contentDescription = "Icon",
                    modifier = Modifier.size(40.dp)
                )

                Column {
                    Text(
                        text = it, fontSize = 12.sp, fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(4.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )

                    if (task != null) {
                        Text(
                            text = when (it) {
                                "Category" -> task.category
                                "Status" -> task.status
                                "Priority" -> task.priority
                                else -> "N/A"
                            }, fontSize = 12.sp,
                            modifier = Modifier.padding(4.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
    var isChecked by remember { mutableStateOf(false) }
    Section_W4_Ex2(
        "Subtasks",
        action = {
            task?.subtasks?.forEach { subtask ->
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = { isChecked = !isChecked }
                        )
                        Column {
                            Text(text = subtask.title)
                        }
                    }
                }
            }
        }
    )

    Section_W4_Ex2(
        "Attachments",
        action = {
            task?.attachments?.forEach {
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Done, contentDescription = "Icon"
                        )

                        Spacer(Modifier.width(10.dp))
                        Column {
                            Text(text = it.fileUrl)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun Section_W4_Ex2(
    titleSection: String = "",
    action: @Composable (ColumnScope.() -> Unit)? = {}
) {
    Column {
        Text( text = titleSection, fontWeight = FontWeight.Bold, fontSize = 18.sp )
        action?.invoke(this)
    }
}


@Preview(showBackground = true)
@Composable
fun Preview123123() {
//    W4_Exercise2(navController = rememberNavController())
    W4_Ex2_Page2(navController = rememberNavController(), 1)
}

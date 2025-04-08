package com.example.baitaplaptrinhdidong.ui.features.week6

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaplaptrinhdidong.ui.base.BaseScreen
import com.example.baitaplaptrinhdidong.ui.components.BackButton

@Composable
fun W6_AddScreen(
    navController: NavController,
    viewModel: W6ViewModel
) {
    BaseScreen(
        actionsTop = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackButton(navController)

                Spacer(Modifier.weight(0.6f))
                Text(
                    "Add New",
                    fontSize = 32.sp, fontWeight = FontWeight.Bold,
                    color = Color(0xFF40C2FD)
                )

                Spacer(Modifier.weight(1f))
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FormAddTask(viewModel)
        }
    }
}

@Composable
fun FormAddTask(
    viewModel: W6ViewModel
) {
    val taskState by viewModel.taskState.collectAsState()
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    OutlinedTextField(
        value = taskState.task,
        onValueChange = { viewModel.onChangeTask(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
            .focusRequester(focusRequester),
        label = { Text("Task") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        maxLines = 1
    )

    OutlinedTextField(
        value = taskState.description,
        onValueChange = { viewModel.onChangeDescription(it) },
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(vertical = 20.dp)
            .focusRequester(focusRequester),
        label = { Text("Description") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                if (taskState.task.isNotBlank() && taskState.description.isNotBlank()) {
                    viewModel.addNewTask()
                    Toast.makeText(context, "Đã tạo thành công", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                }
            }
        ),
        maxLines = 4
    )

    Button (
        onClick = {
            if (taskState.task.isNotBlank() && taskState.description.isNotBlank()) {
                viewModel.addNewTask()
                Toast.makeText(context, "Đã tạo thành công", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            }
        },
        modifier = Modifier
            .fillMaxWidth(0.4f)
            .size(100.dp)
            .padding(vertical = 20.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF40C2FD))
    ) {
        Text(
            "Add",
            fontSize = 18.sp, fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}
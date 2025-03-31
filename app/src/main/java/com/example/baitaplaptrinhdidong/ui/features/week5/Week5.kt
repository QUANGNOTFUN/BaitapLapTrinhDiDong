package com.example.baitaplaptrinhdidong.ui.features.week5

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.data.service.auth.SignIn
import com.example.baitaplaptrinhdidong.ui.base.BaseScreen

@Composable
fun Week5(
    navController: NavHostController,
    viewModel: Week5ViewModel = viewModel()
) {
    val context = LocalContext.current

    // Launcher
    val launcher =  rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            if (viewModel.handleGoogleSignIn(intent))
                navController.navigate("w5_info_user")
        }
    }

    BaseScreen(
        actionsBot = {
            Text("©UTHSmartTasks",
                fontSize = 14.sp, fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth().wrapContentWidth()
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card (
                modifier = Modifier
                    .size(200.dp)
                    .background(Color(0xFFC6EBFF), shape = RoundedCornerShape(20.dp))
                    .wrapContentSize()
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_logo_uth),
                    contentDescription = "Logo",
                    modifier = Modifier.background(Color(0xFFC6EBFF))
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text("SmartTasks", fontWeight = FontWeight.Bold, fontSize = 26.sp,
                    color = Color(0xFF03A9F4))

                Spacer(modifier = Modifier.height(10.dp))

                Text("A simple and efficient to-do app", fontSize = 14.sp,
                    color = Color(0xFF00BCD4)
                )
            }
            Spacer(modifier = Modifier.height(100.dp))

            Text("Welcome", fontSize = 16.sp,
                color = Color.Black
            )
            Text("Ready to explore? Log in to get started.", fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                modifier = Modifier
                    .background(Color(0xFFC6EBFF), shape = RoundedCornerShape(10.dp))
                    .clickable {
                        val signInIntent = SignIn().getGoogleSignIn(context)
                        launcher.launch(signInIntent)
                    }
                    .padding(40.dp, 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_logo_google),
                    contentDescription = "Logo",
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Text("SING IN WITH GOOGLE", fontSize = 16.sp, fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}


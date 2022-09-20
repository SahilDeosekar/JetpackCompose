package com.example.exercise1.view

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.exercise1.viewmodel.SplashViewModel


@Composable
fun Greeting(name: String) {
    Text(text = "$name", color = Color.Red, fontSize = 150.sp, fontFamily = FontFamily.Cursive)
}

@Composable
fun Splash(name: String, navController: NavController, context: Context,splashViewModel: SplashViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        contentAlignment = Alignment.Center,
    )
    {
        Greeting(name)
    }
    splashViewModel.validateUserData(navController,context, rememberCoroutineScope())
}



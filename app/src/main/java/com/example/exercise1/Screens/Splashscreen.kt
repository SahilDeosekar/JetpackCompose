package com.example.exercise1.Screens

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.estimateAnimationDurationMillis
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.exercise1.data.loadData
import com.example.exercise1.data.user
import kotlinx.coroutines.delay

@Composable
fun Greeting(name: String) {
    Text(text = "$name", color = Color.Red, fontSize = 60.sp, fontFamily = FontFamily.Cursive)
}

@Composable
fun Splash(name: String, navController: NavController, context: Context) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        contentAlignment = Alignment.Center,
    )
    {
        loadData(context)
        Greeting(name)
        LaunchedEffect(key1 = true)
        {
            delay(1000L)
            if (user.userName.isEmpty() && user.password.isEmpty()) {
                navController.navigate(route = Screen.Loginpage.route){
                    popUpTo(Screen.Splash.route){inclusive=true}
                }
            } else {
                navController.navigate(route = Screen.Welcome.route){
                    popUpTo(Screen.Splash.route){inclusive=true}
                }
            }
        }
    }
}



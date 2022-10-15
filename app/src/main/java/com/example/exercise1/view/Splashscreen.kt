package com.example.exercise1.view


import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.exercise1.R
import com.example.exercise1.ui.theme.LightGreen
import com.example.exercise1.viewmodel.SplashViewModel


@Composable
fun Greeting(name: String) {
    Text(text = "$name", color = Color.Red, fontSize = 30.sp, fontFamily = FontFamily.Cursive)
}

@Composable
fun Splash(
    name: String,
    navController: NavController,
    context: Context,
    splashViewModel: SplashViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGreen),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.ic_baseline_anchor_24),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(300.dp)
        )
        Greeting(name)
    }
    Log.d("TAG", "Splash: verified")
    splashViewModel.validateUserData(navController, context)

}



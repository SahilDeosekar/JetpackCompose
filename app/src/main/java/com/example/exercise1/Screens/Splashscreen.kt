package com.example.exercise1.Screens

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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.exercise1.ui.theme.Exercise1Theme
import kotlinx.coroutines.delay

@Composable
fun Greeting(name: String) {
    Text(text = "$name", color = Color.Red, fontSize = 60.sp, fontFamily = FontFamily.Cursive)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Exercise1Theme {
        Greeting("Sahil")
    }
}

@Composable
fun Splash(name: String){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        contentAlignment = Alignment.Center
    )
    {
        Animation(name)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Animation(name: String)
{
    var visible by remember { mutableStateOf(true) }
    AnimatedVisibility(
        visible = visible,
        enter = scaleIn(),
        exit = scaleOut()
    ) {
        Greeting(name)
    }
}


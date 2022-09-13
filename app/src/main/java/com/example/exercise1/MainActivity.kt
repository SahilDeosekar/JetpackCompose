package com.example.exercise1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.exercise1.Screens.Loginpage
import com.example.exercise1.Screens.Welcome
import com.example.exercise1.Screens.columnpreview
import com.example.exercise1.ui.theme.Exercise1Theme
import kotlinx.coroutines.delay
import javax.xml.transform.Result
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Exercise1Theme {
                columnpreview("Sahil")
            }
        }
        thread {
                Thread.sleep(1000)
            this.setContent{
                Loginpage{this.setContent{ Welcome()}}
            }
        }
    }
}


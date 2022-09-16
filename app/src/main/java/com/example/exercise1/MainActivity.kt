package com.example.exercise1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.exercise1.ui.theme.Exercise1Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Exercise1Theme {
                getApiData()
                SetupNavGraph(rememberNavController(), this)
            }
        }
//    loadData(this)
//    thread {
//        Thread.sleep(1000)
//        if(user.userName.isEmpty()&& user.password.isEmpty()) {
//            this.setContent{Loginpage{this.setContent {Welcome()}}}}
//            else { this.setContent { Welcome() } }
//        }
    }
}



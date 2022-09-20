package com.example.exercise1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.exercise1.ui.theme.Exercise1Theme
import com.example.exercise1.viewmodel.HomeViewModel
import com.example.exercise1.viewmodel.LoginViewModel
import com.example.exercise1.viewmodel.SplashViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashViewModel: SplashViewModel by viewModels()
        val loginViewModel: LoginViewModel by viewModels()
        val homeViewModel: HomeViewModel by viewModels()
        setContent {
            Exercise1Theme {
                getApiData()
                SetupNavGraph(rememberNavController(), this,splashViewModel,loginViewModel,homeViewModel)
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



package com.example.exercise1.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.exercise1.utility.Screen
import com.example.exercise1.model.loadData
import com.example.exercise1.model.user
import com.example.exercise1.readJsonFromAssets
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {

    fun validateUserData(navController: NavController,context: Context){
        viewModelScope.launch{
            delay(1000)
            loadData(context)
            readJsonFromAssets(context)
            if (user.userName.isEmpty() && user.password.isEmpty()) {
                navController.navigate(route = Screen.Loginpage.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            } else {
                navController.navigate(route = Screen.Welcome.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            }
        }
    }
}
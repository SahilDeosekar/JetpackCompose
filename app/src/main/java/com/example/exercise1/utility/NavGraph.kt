package com.example.exercise1

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.exercise1.view.Home
import com.example.exercise1.view.Loginpage
import com.example.exercise1.utility.Screen
import com.example.exercise1.view.Splash
import com.example.exercise1.viewmodel.HomeViewModel
import com.example.exercise1.viewmodel.LoginViewModel
import com.example.exercise1.viewmodel.SplashViewModel

@Composable
fun SetupNavGraph(navController: NavHostController, context: Context,splashViewModel: SplashViewModel,loginViewModel: LoginViewModel,homeViewModel: HomeViewModel) {
    NavHost(navController = navController, startDestination = Screen.Splash.route)
    {
        composable(
            route = Screen.Splash.route
        ) {
            Splash("Sahil", navController, context,splashViewModel)
        }
        composable(
            route = Screen.Loginpage.route
        ) {
            Loginpage(navController,context,loginViewModel)
        }
        composable(
            route = Screen.Welcome.route
        ) {
            Home()
        }
    }
}
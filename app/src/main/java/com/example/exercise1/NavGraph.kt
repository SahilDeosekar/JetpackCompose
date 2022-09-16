package com.example.exercise1

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.exercise1.Screens.Loginpage
import com.example.exercise1.Screens.Screen
import com.example.exercise1.Screens.Splash
import com.example.exercise1.Screens.Welcome

@Composable
fun SetupNavGraph(navController: NavHostController,context: Context)
{
    NavHost(navController = navController, startDestination = Screen.Splash.route)
    {
        composable(
            route = Screen.Splash.route
        ){
            Splash("Sahil", navController, context)
        }
        composable(
            route = Screen.Loginpage.route
        ){
            Loginpage(navController = navController,context)
        }
        composable(
            route = Screen.Welcome.route
        ){
            Welcome(navController = navController,context)
        }
    }
}
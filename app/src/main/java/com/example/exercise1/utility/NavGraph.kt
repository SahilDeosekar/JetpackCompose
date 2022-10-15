package com.example.exercise1.utility

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.exercise1.model.Products
import com.example.exercise1.view.*

@Composable
fun SetupNavGraph(navController: NavHostController, context: Context) {
    NavHost(navController = navController, startDestination = Screen.Splash.route)
    {
        composable(
            route = Screen.Splash.route
        ) {
            Splash("Sahil", navController, context)
        }
        composable(
            route = Screen.Loginpage.route
        ) {
            Loginpage(navController, context)
        }
        composable(
            route = Screen.Welcome.route
        ) {
            Home(navController)
        }
        composable(
            route = Screen.Description.route
        ) {
            ShowDescriptionfun()
        }
    }
}
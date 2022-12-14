package com.example.exercise1.Screens

sealed class Screen(val route: String){
    object Splash: Screen(route = "splashscreen")
    object Loginpage: Screen(route = "loginscreen")
    object Welcome: Screen(route = "homescreen")
}

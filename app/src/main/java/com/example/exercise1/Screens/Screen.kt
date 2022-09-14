package com.example.exercise1.Screens

sealed class Screen(val route: String){
    object splash: Screen(route = "splashscreen")
    object Loginpage: Screen(route = "loginscreen")
    object Welcome: Screen(route = "homescreen")
}

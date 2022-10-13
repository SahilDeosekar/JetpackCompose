package com.example.exercise1

import android.content.Context
import android.util.Log
import com.example.exercise1.model.*
import com.example.exercise1.utility.Apiinterface
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

lateinit var apihelper: User
var json = ""
fun convertToObject() {
    val gson = Gson()
    apihelper = gson.fromJson(json, User::class.java)
    Log.d("Sahil", "convertToObject:${apihelper.userName}")
}


fun validate(inputName: String, inputPassword: String): Boolean {
    return (inputName == apihelper.userName && inputPassword == apihelper.password)
}

fun readJsonFromAssets(context: Context) {
    json = context.assets.open("user.json").bufferedReader().use {
        it.readText()
    }
}


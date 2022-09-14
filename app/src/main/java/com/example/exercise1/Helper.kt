package com.example.exercise1

import android.util.Log
import com.example.exercise1.data.Products
import com.example.exercise1.data.User
import com.example.exercise1.data.data
import com.example.exercise1.data.json
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.zip.CheckedInputStream

lateinit var apihelper: User

fun convertToObject(){
    val gson = Gson()
    apihelper= gson.fromJson(json, User::class.java)
    Log.d("Sahil", "convertToObject:${apihelper.userName}")
}


fun validate(inputName: String, inputPassword:String):Boolean
{
    return (inputName== apihelper.userName && inputPassword== apihelper.password)
}

var index = 0
lateinit var productList: Array<Products>
fun convertToArray(){
    var gson = Gson()
    val typeToken = object : TypeToken<Array<Products>>(){}.type
    productList = gson.fromJson(data, typeToken)
}
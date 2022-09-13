package com.example.exercise1

import android.util.Log
import com.example.exercise1.data.User
import com.example.exercise1.data.json
import com.google.gson.Gson
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
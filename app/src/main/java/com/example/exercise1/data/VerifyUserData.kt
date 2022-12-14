package com.example.exercise1.data

import android.content.Context
import android.util.Log

private const val USER_VERIFICATION = "USER_VERIFICATION"
private const val USER_NAME_KEY = "USER_NAME_KEY"
private const val PASSWORD_KEY = "PASSWORD_KEY"

fun saveData(context: Context,userName: String,password: String){
    val sharedPreferences = context.getSharedPreferences(USER_VERIFICATION,Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.apply {
        putString(USER_NAME_KEY,userName)
        putString(PASSWORD_KEY,password)
        apply()
    }
}

//If shared pref does not exist, userName and password will contain empty string
fun loadData(context: Context){
    val sharedPreferences = context.getSharedPreferences(USER_VERIFICATION,Context.MODE_PRIVATE)
    user.userName = sharedPreferences.getString(USER_NAME_KEY,"").toString()
    user.password = sharedPreferences.getString(PASSWORD_KEY,"").toString()
    Log.d("SahilX", "loadData: ${user.userName}")
}
package com.example.exercise1.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.exercise1.convertToObject
import com.example.exercise1.model.saveData
import com.example.exercise1.model.user
import com.example.exercise1.utility.Screen
import com.example.exercise1.validate

class LoginViewModel : ViewModel() {
    private val _inputusername = mutableStateOf("")
    val inputusername = _inputusername

    private val _inputpassword = mutableStateOf("")
    val inputpassword = _inputpassword

    private val _passwordVisible = mutableStateOf(false)
    val passwordVisible = _passwordVisible


    fun login(mContext: Context, navController: NavController) {
        convertToObject()
        if (validate(user.userName, user.password)) {
            saveData(mContext, user.userName, user.password)
            navController.navigate(route = Screen.Welcome.route) {
                popUpTo(Screen.Loginpage.route) {
                    inclusive = true
                }
            }
        } else mToast(mContext)
    }

    private fun mToast(context: Context) {
        Toast.makeText(context, "Signin Failed", Toast.LENGTH_LONG).show()
    }


    fun usernamechange(it: String) {
        _inputusername.value = it
    }

    fun usernamesave() {
        user.userName = _inputusername.value
    }

    fun passwordchange(it: String) {
        _inputpassword.value = it
    }

    fun passwordsave() {
        user.password = _inputpassword.value
    }

    fun passwordvisibility(): Boolean{
        return passwordVisible.value
    }

    fun passwordchange(){
        _passwordVisible.value=!_passwordVisible.value
    }



}
package com.example.exercise1.view

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.exercise1.viewmodel.LoginViewModel

@Composable
fun Loginpage(navController: NavController,context: Context,loginViewModel: LoginViewModel) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        DrawRowsUsername(loginViewModel)
        DrawRowsPassword(loginViewModel)
        Button(onClick = {
            loginViewModel.login(context,navController)
        }) {
            Text(text = "Sign In")
        }


    }
}

@Composable
fun DrawRowsUsername(loginViewModel: LoginViewModel) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {
        Column(modifier = Modifier.padding(10.dp)) { Text(text = "User Name") }
        Column(modifier = Modifier.padding(10.dp)) {

            TextField(value = loginViewModel.inputusername.value, onValueChange = { loginViewModel.usernamechange(it)},
                label = { Text(text = "Enter Username") })
            loginViewModel.usernamesave()
        }
    }
}

@Composable
fun DrawRowsPassword(loginViewModel: LoginViewModel) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {
        Column(modifier = Modifier.padding(10.dp)) { Text(text = "Password") }
        Column(modifier = Modifier.padding(10.dp)) {

            TextField(
                value = loginViewModel.inputpassword.value, onValueChange = {loginViewModel.passwordchange(it)},
                label = { Text(text = "Enter password") },
                visualTransformation = if (loginViewModel.passwordvisibility()) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (loginViewModel.passwordvisibility())
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff
                    val description = if (loginViewModel.passwordvisibility()) "Hide password" else "Show password"

                    IconButton(onClick = { loginViewModel.passwordchange() }) {
                        Icon(imageVector = image, description)
                    }
                })
            loginViewModel.passwordsave()
        }
    }
}
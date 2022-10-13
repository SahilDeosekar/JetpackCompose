package com.example.exercise1.view

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.exercise1.R
import com.example.exercise1.viewmodel.LoginViewModel

@Composable
fun Loginpage(
    navController: NavController,
    context: Context,
    loginViewModel: LoginViewModel = viewModel()
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
            Brush.verticalGradient(
                colors = listOf(Color.Transparent, Color.Cyan),
                startY = 400f
            )
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Image(
            painterResource(R.drawable.img_user),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(80.dp)
        )
        DrawRowsUsername(loginViewModel)
        DrawRowsPassword(loginViewModel)
        Button(shape = RoundedCornerShape(40.dp), onClick = {
            loginViewModel.login(context, navController)
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

            OutlinedTextField(value = loginViewModel.inputusername.value,
                onValueChange = { loginViewModel.usernamechange(it) },
                shape = RoundedCornerShape(20.dp),
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
        Column(modifier = Modifier.padding(10.dp)) { Text(text = "Password  ") }
        Column(modifier = Modifier.padding(10.dp)) {

            OutlinedTextField(
                value = loginViewModel.inputpassword.value,
                shape = RoundedCornerShape(20.dp),
                onValueChange = { loginViewModel.passwordchange(it) },
                label = { Text(text = "Enter password") },
                visualTransformation = if (loginViewModel.passwordvisibility()) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (loginViewModel.passwordvisibility())
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff
                    val description =
                        if (loginViewModel.passwordvisibility()) "Hide password" else "Show password"

                    IconButton(onClick = { loginViewModel.passwordchange() }) {
                        Icon(imageVector = image, description)
                    }
                })
            loginViewModel.passwordsave()
        }
    }
}
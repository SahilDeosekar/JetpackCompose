package com.example.exercise1.Screens

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.exercise1.convertToObject
import com.example.exercise1.data.user
import com.example.exercise1.validate

@Composable
fun Loginpage(onClickLambda: ()->Unit={}) {
    val usernamelist = mutableListOf("User Name", "Enter Username")
    val passwordlist = mutableListOf("Password", "Enter password")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        val mContext = LocalContext.current
        DrawRowsUsername(list = usernamelist)
        DrawRowsPassword(list = passwordlist)
        Button(onClick = {
            convertToObject()
            if(validate(user.userName,user.password)) onClickLambda()
            else mToast(mContext)}) {
            Text(text = "SignIn")
        }

    }
}
private fun mToast(context: Context){
    Toast.makeText(context, "Signin Failed", Toast.LENGTH_LONG).show()
}

@Composable
fun DrawRowsUsername(list: List<String>){
    Row(modifier = Modifier,
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center)
    {
        Column(modifier = Modifier.padding(10.dp)) { Text(text=list[0])}
        Column(modifier= Modifier.padding(10.dp)) {
            val input = remember { mutableStateOf("")}

            TextField(value = input.value, onValueChange = {input.value=it},
            label = { Text(text = list[1])})
            user.userName= input.value
        }
    }
}
@Composable
fun DrawRowsPassword(list: List<String>){
    Row(modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
    {
        Column(modifier = Modifier.padding(10.dp)) { Text(text=list[0])}
        Column(modifier= Modifier.padding(10.dp)) {
            var input = remember { mutableStateOf("")}
            var passwordVisible by remember { mutableStateOf(false) }

            TextField(
                value = input.value, onValueChange = {input.value=it},
                label = { Text(text = list[1])},
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = {passwordVisible = !passwordVisible}) {
                        Icon(imageVector = image, description)
                    }
                    })
            user.password = input.value
        }
    }
}
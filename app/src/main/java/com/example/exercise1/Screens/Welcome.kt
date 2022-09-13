package com.example.exercise1.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exercise1.data.user

@Preview(showBackground = true)
@Composable
fun Welcome(){
    Surface(modifier = Modifier
        .fillMaxSize()) {
        Column(

            modifier = Modifier
                .background(Color.Yellow),
        ) {
            ShowAlert()
        }
    }
}

@Composable
fun ShowAlert()
{
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {

        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            shape = RoundedCornerShape(10.dp),
            title = {
                Text(text = "WELCOME")
            },
            text = {
                Text("${user.userName}")
            },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                    }) { Text("Ok") }
            },
        )
    }
}
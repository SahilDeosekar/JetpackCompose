package com.example.exercise1.Screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.exercise1.convertToArray
import com.example.exercise1.data.user
import com.example.exercise1.index
import com.example.exercise1.productList

@Composable
fun Welcome(navController: NavController, context: Context){
    Surface(modifier = Modifier
        .fillMaxSize()) {
        Column(

            modifier = Modifier
                .background(Color.Yellow),
        ) {
            ShowAlert()
            HomeScreenTheme()
        }
    }
}
@Composable
fun HomeScreenTheme(){
    val numberOfRows = 2
    convertToArray() //Convert JSON to Kotlin Array

    //Main Column
    Column(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        for (i in 1..numberOfRows) DrawHomeRows()
    }
}

@Composable
fun DrawHomeRows(){
    Row(){
        Box(modifier = Modifier.fillMaxWidth(0.5f).padding(10.dp)) {
            DrawHomeEachColumn()
        }
        Box(modifier = Modifier.padding(10.dp)) {
            DrawHomeEachColumn()
        }
    }
}

@Composable //Generates Each individual card in of each column in a row
fun DrawHomeEachColumn(){
    index++
    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp)) {
        Column(
            modifier = Modifier.height(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = productList[index].imageUrl.toInt()),
                contentDescription = "",
                contentScale = ContentScale.Fit)
            Text(text = productList[index].productName)
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
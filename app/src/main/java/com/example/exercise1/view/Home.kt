package com.example.exercise1.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.exercise1.model.Products
import com.example.exercise1.model.user
import com.example.exercise1.productList
import com.example.exercise1.ui.theme.Teal200
import com.example.exercise1.viewmodel.HomeViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home(homeScreenViewModel: HomeViewModel = viewModel()) {
//    var newList = productList ?: listOf<Products>()
    ShowAlert()
    LaunchedEffect(key1 = true) {
        homeScreenViewModel.start()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = Modifier.background(Color.Cyan),
            content = {
                items(homeScreenViewModel.productListSate.value.size) { index ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .padding(5.dp),
                        elevation = 10.dp,
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Image(
                            painter = rememberImagePainter(homeScreenViewModel.productListSate.value[index].imageUrl),
                            contentDescription = "",
                            contentScale = ContentScale.Fit
                        )

                        Box(
                            contentAlignment = Alignment.BottomCenter,
                            modifier = Modifier.background(
                                Brush.verticalGradient(
                                    colors = listOf(Color.Transparent, Color.Black),
                                    startY = 400f
                                )
                            )
                        ) {
                            Text(
                                text = homeScreenViewModel.productListSate.value[index].productName,
                                modifier = Modifier.padding(5.dp),
                                color = Color.White,
                                fontStyle = FontStyle.Italic

                            )
                        }
                    }
                }
            })
        if (homeScreenViewModel.networkStatusState.value == "Fetching") {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
                Text(text = "Fetching..")
            }
        }
        if (homeScreenViewModel.networkStatusState.value == "Failed") {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Failed..", color = Color.Red, fontSize = 30.sp)
            }
        }
    }
}

//@Composable
//fun HomeScreenTheme() {
//    val numberOfRows = 2
//
//    //Main Column
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black)
//    ) {
//        for (i in 1..numberOfRows) DrawHomeRows()
//    }
//}
//
//@Composable
//fun DrawHomeRows() {
//    Row() {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth(0.5f)
//                .padding(10.dp)
//        ) {
//            DrawHomeEachColumn()
//        }
//        Box(modifier = Modifier.padding(10.dp)) {
//            DrawHomeEachColumn()
//        }
//    }
//}
//
//@Composable //Generates Each individual card in of each column in a row
//fun DrawHomeEachColumn() {
//    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp)) {
//        Column(
//            modifier = Modifier.height(200.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Image(
//                painter = painterResource(id = productList[index].imageUrl.toInt()),
//                contentDescription = "",
//                contentScale = ContentScale.Fit
//            )
//            Text(text = productList[index].productName)
//        }
//    }
//}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowAlert() {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {

        AlertDialog(

            backgroundColor = Teal200,
            onDismissRequest = {
                openDialog.value = false
            },
            shape = RoundedCornerShape(10.dp),
            title = {
                Text(
                    text = "WELCOME",
                    color = Color.Red,
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic
                )
            },
            text = {
                Text("${user.userName}", fontFamily = FontFamily.Cursive, fontSize = 40.sp)
            },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                    }, shape = RoundedCornerShape(10.dp)
                ) { Text("Ok") }
            },
        )
    }
}

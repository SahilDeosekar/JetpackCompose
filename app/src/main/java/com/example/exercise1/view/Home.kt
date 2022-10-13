package com.example.exercise1.view

import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.exercise1.model.user
import com.example.exercise1.ui.theme.Teal200
import com.example.exercise1.viewmodel.HomeViewModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalCoilApi::class)
@Composable
fun Home(homeScreenViewModel: HomeViewModel = viewModel()) {
    val activity = (LocalContext.current as? Activity)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Shopping")
                },
                navigationIcon = {
                    IconButton(onClick = { activity?.finish() }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp
            )
        },
        content = {
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
                    modifier = Modifier.background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Cyan),
                            startY = 400f
                        )
                    ),
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
                                    contentAlignment = BottomCenter,
                                    modifier = Modifier.background(
                                        Brush.verticalGradient(
                                            colors = listOf(Color.Transparent, Color.Black),
                                            startY = 400f
                                        )
                                    )
                                ) {
                                    Column(verticalArrangement = Arrangement.Bottom) {

                                        Text(
                                            text = homeScreenViewModel.productListSate.value[index].productName,
                                            modifier = Modifier.padding(5.dp),
                                            color = Color.White,
                                            textAlign= TextAlign.Center,
                                            fontStyle = FontStyle.Italic

                                        )
                                        Text(
                                            text = homeScreenViewModel.productListSate.value[index].cost + "$",
                                            modifier = Modifier.padding(5.dp),
                                            color = Color.White,
                                            textAlign= TextAlign.Center,
                                            fontStyle = FontStyle.Italic

                                        )
                                    }
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
        })
}


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
                Text(user.userName, fontFamily = FontFamily.Cursive, fontSize = 40.sp)
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

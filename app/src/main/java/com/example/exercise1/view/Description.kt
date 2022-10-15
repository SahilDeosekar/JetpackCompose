package com.example.exercise1.view

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.exercise1.ui.theme.LightGreen
import com.example.exercise1.viewmodel.DescriptionViewmodel

@Composable
fun ShowDescriptionfun(descriptionViewModel: DescriptionViewmodel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGreen),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.border(BorderStroke(5.dp, Color.Gray), RoundedCornerShape(30.dp)),
            elevation = 10.dp,
            shape = RoundedCornerShape(30.dp),

            ) {

            Image(
                painter = rememberImagePainter(descriptionViewModel.description.imageUrl),
                contentDescription = "",
                modifier = Modifier
                    .size(300.dp),
            )
        }
        Text(
            text = descriptionViewModel.description.productName,
            color = Color.Black,
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic
        )
        Text(text = "Description", fontSize = 20.sp)
        Text(text = descriptionViewModel.description.desc)
        Log.d("Sah", descriptionViewModel.description.productName)
    }

}
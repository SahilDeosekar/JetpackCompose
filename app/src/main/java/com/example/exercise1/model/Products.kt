package com.example.exercise1.model

import com.google.gson.annotations.SerializedName


data class Products(
    @SerializedName("title")
    var productName: String,

    @SerializedName("image")
    var imageUrl: String
    )
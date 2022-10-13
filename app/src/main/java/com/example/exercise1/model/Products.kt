package com.example.exercise1.model

import com.google.gson.annotations.SerializedName


data class Products(
    @SerializedName("title")
    var productName: String,

    @SerializedName("image")
    var imageUrl: String,

    @SerializedName("price")
    var cost: String,

    @SerializedName("description")
    var desc: String
)

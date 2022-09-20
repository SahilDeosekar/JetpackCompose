package com.example.exercise1

import android.content.Context
import android.util.Log
import com.example.exercise1.model.*
import com.example.exercise1.utility.Apiinterface
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

lateinit var apihelper: User
var productList: List<Products>? = null
var json = ""
fun convertToObject() {
    val gson = Gson()
    apihelper = gson.fromJson(json, User::class.java)
    Log.d("Sahil", "convertToObject:${apihelper.userName}")
}


fun validate(inputName: String, inputPassword: String): Boolean {
    return (inputName == apihelper.userName && inputPassword == apihelper.password)
}

fun readJsonFromAssets(context: Context) {
    json = context.assets.open("user.json").bufferedReader().use {
        it.readText()
    }
}

fun getApiData()    {

    val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://fakestoreapi.com/")
        .build()
        .create(Apiinterface::class.java)

    val retrofitData = retrofitBuilder.getdata()

    retrofitData.enqueue(object : Callback<List<Products>?> {
        override fun onResponse(call: Call<List<Products>?>, response: Response<List<Products>?>) {

            if (response.body() != null) productList = response.body()!!
        }

        override fun onFailure(call: Call<List<Products>?>, t: Throwable) {

        }
    })
}
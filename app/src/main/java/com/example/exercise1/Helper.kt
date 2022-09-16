package com.example.exercise1

import android.content.Context
import android.util.Log
import com.example.exercise1.data.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.zip.CheckedInputStream

lateinit var apihelper: User
var productList: List<Products>?=null

fun convertToObject() {
    val gson = Gson()
    apihelper = gson.fromJson(json, User::class.java)
    Log.d("Sahil", "convertToObject:${apihelper.userName}")
}


fun validate(inputName: String, inputPassword: String): Boolean {
    return (inputName == apihelper.userName && inputPassword == apihelper.password)
}

fun readJsonFromAssets(context: Context){
    json = context.assets.open("user.json").bufferedReader().use {
        it.readText()
    }
}

fun getApiData(){

    val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://fakestoreapi.com/")
        .build()
        .create(Apiinterface::class.java)

    val retrofitData = retrofitBuilder.getdata()

    retrofitData.enqueue(object : Callback<List<Products>?> {
        override fun onResponse(call: Call<List<Products>?>, response: Response<List<Products>?>){
            Log.d("RetFt", "onResponse: ${response.body().toString()}")
            if(response.body() != null) productList = response.body()!!
            Log.d("RetFt", "onResponse: size = ${productList?.size}")
        }

        override fun onFailure(call: Call<List<Products>?>, t: Throwable) {
            Log.d("RetFt", "onFailure: $t")
        }
    })
}
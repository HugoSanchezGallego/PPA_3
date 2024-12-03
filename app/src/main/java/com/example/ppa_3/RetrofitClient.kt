package com.example.ppa_3

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://www.zaragoza.es/georref/json/hilo/farmacias_Equipamiento/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
package com.example.ppa_3

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("your_endpoint")
    fun getFarmacias(): Call<FarmaciaResponse>
}
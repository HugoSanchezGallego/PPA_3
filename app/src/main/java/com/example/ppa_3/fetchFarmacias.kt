package com.example.ppa_3

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

fun loadJSONFromAsset(context: Context, fileName: String): String? {
    return try {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        String(buffer, Charsets.UTF_8)
    } catch (ex: IOException) {
        ex.printStackTrace()
        null
    }
}

fun fetchFarmacias(context: Context): List<Feature> {
    val json = loadJSONFromAsset(context, "farmacias.json")
    if (json != null) {
        val gson = Gson()
        val farmaciaResponseType = object : TypeToken<FarmaciaResponse>() {}.type
        val farmaciaResponse: FarmaciaResponse = gson.fromJson(json, farmaciaResponseType)
        return farmaciaResponse.features
    }
    return emptyList()
}
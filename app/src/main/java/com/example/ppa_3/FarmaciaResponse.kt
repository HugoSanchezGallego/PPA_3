package com.example.ppa_3

data class FarmaciaResponse(
    val type: String,
    val crs: Crs,
    val properties: Properties,
    val features: List<Feature>
)

data class Crs(
    val type: String,
    val properties: CrsProperties
)

data class CrsProperties(
    val code: Int
)

data class Properties(
    val title: String,
    val icon: String,
    val link: String,
    val description: String
)

data class Feature(
    val type: String,
    val geometry: Geometry,
    val properties: FeatureProperties
)

data class Geometry(
    val type: String,
    val coordinates: List<Double>
)

data class FeatureProperties(
    val title: String,
    val link: String,
    val description: String,
    val category: String,
    val date: String,
    val icon: String
)
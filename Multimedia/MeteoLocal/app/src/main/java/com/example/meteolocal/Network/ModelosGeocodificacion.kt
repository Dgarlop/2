package com.example.meteolocal.Network

data class RespuestaGeocodificacion(
    val results: List<Lugar>?
)
data class Lugar(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val country: String?
)
package com.example.meteolocal.Network

data class ResultadoMeteo(
    val localidad: String,
    val pais: String?,
    val temperatura: Double,
    val sensacion: Double,
    val humedad: Int,
    val codigo: Int,
    val viento: Double
)

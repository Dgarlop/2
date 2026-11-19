package com.example.meteolocal.Network

data class RespuestaMeteo(
    val current: TiempoActual
)
data class TiempoActual(
    val temperature_2m: Double
)
package com.example.cochesMySQL.model

data class ConcesionarioConCochesDTO(
    val id: Int?,
    val nombre: String,
    val coches: List<Coche>,
    val marcas: List<String>
)

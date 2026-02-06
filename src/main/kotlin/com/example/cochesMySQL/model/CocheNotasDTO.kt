package com.example.cochesMySQL.model

data class CocheNotasDTO (
    val coche: Coche,
    val notas: List<Nota> = emptyList()
)
package com.example.cochesMySQL.model.modelDTO

import com.example.cochesMySQL.model.Coche

data class PrecioCoche(
    val coche: Coche,
    val precio: Int?=null
)
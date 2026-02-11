package com.example.cochesMySQL.model.modelDTO

import com.example.cochesMySQL.model.Coche
import com.example.cochesMySQL.model.Nota

data class CocheNotas (
    val coche: Coche,
    val notas: List<Nota> = emptyList()
)
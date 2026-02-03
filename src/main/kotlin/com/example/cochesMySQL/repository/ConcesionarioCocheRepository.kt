package com.example.cochesMySQL.repository

import com.example.cochesMySQL.model.ConcesionarioCoche
import com.example.cochesMySQL.model.ConcesionarioCocheId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface ConcesionarioCocheRepository :
    JpaRepository<ConcesionarioCoche, ConcesionarioCocheId>{
    @Query("""
        SELECT cc
        FROM ConcesionarioCoche cc
        JOIN cc.coche c
        WHERE cc.concesionario.id_concesionario = :idConcesionario
        ORDER BY c.marca, c.modelo
    """)
    fun obtenerCochesDeConcesionario(
        @Param("idConcesionario") idConcesionario: Int
    ): List<ConcesionarioCoche>
    }



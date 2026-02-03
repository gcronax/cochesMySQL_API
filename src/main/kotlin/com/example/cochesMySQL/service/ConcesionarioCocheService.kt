package com.example.cochesMySQL.service

import com.example.cochesMySQL.model.Concesionario
import com.example.cochesMySQL.model.ConcesionarioCoche
import com.example.cochesMySQL.model.ConcesionarioCocheId
import com.example.cochesMySQL.model.Coche
import com.example.cochesMySQL.repository.ConcesionarioCocheRepository
import com.example.cochesMySQL.repository.CocheRepository
import com.example.cochesMySQL.repository.ConcesionarioRepository
import org.springframework.stereotype.Service

@Service
class ConcesionarioCocheService(
    private val concesionarioCocheRepository: ConcesionarioCocheRepository,
    private val concesionarioRepository: ConcesionarioRepository,
    private val cocheRepository: CocheRepository
) {

    fun listarTodas(): List<ConcesionarioCoche> =
        concesionarioCocheRepository.findAll()

    fun listarConcesionarios(): List<Concesionario> = concesionarioRepository.findAll()
    fun listarCoches(): List<Coche> = cocheRepository.findAll()
    fun obtenerCochesDeConcesionario(idConcesionario: Int): List<ConcesionarioCoche> =
        concesionarioCocheRepository.obtenerCochesDeConcesionario(idConcesionario)

    fun guardar(idConcesionario: Int, idCoche: Int, cantidad: Int) {
        // 1. Buscamos las entidades (lanzará error si no existen)
        val concesionarioRef = concesionarioRepository.findById(idConcesionario).orElseThrow()
        val cocheRef = cocheRepository.findById(idCoche).orElseThrow()

        // 2. Creamos la clave compuesta
        val id = ConcesionarioCocheId(idConcesionario, idCoche)

        // 3. Creamos la entidad relación
        val nuevaRelacion = ConcesionarioCoche(
            id = id,
            concesionario = concesionarioRef,
            coche = cocheRef,
            cantidad = cantidad
        )

        concesionarioCocheRepository.save(nuevaRelacion)
    }


}

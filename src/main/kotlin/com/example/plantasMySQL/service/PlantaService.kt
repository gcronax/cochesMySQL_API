package com.example.plantasMySQL.service

import com.example.plantasMySQL.model.Planta
import com.example.plantasMySQL.repository.PlantaRepository
import org.springframework.stereotype.Service
import kotlin.compareTo

import java.io.File
import kotlin.collections.map
import kotlin.io.readLines
import kotlin.text.split
import kotlin.text.toDouble


@Service
class PlantaService(private val repository: PlantaRepository) {

    fun listarPlantas(): List<Planta> = repository.findAll()

    fun buscarPorId(id: Int): Planta? = repository.findById(id).orElse(null)

    fun guardar(planta: Planta): Planta = repository.save(planta)

    fun borrar(id: Int) {
        if (repository.existsById(id)) {
            repository.deleteById(id)
        }
    }


    fun importarDesdeCSV() {

        // 1. Verificar si ya hay datos para no duplicar (opcional)
        //if (repository.count() > 0) return

        // 2. Leer el fichero (Lógica del Ejemplo 3)
        val filePath = "src/main/resources/data/plantas.csv"
        val file = File(filePath)

        if (file.exists()) {
            println("el fichero existe")
            val plantasLeidas = file.readLines().map { linea ->
                val partes = linea.split(";")
                // 3. Crear el objeto Planta (Lógica del Ejemplo 4)
                // IMPORTANTE: Ponemos id_planta = null para que se genere uno nuevo
                Planta(
                    id_planta = null,
                    nombre = partes[1],
                    tipo = partes[2],
                    altura = partes[3].toDouble(),
                    foto = partes[4]
                )
            }
            // 4. Guardar todo en la BD de golpe
            repository.saveAll(plantasLeidas)
        }
    }
}
package com.example.plantasMySQL.service

import com.example.plantasMySQL.model.Jardin
import com.example.plantasMySQL.repository.JardinRepository
import org.springframework.stereotype.Service
import kotlin.compareTo

import java.io.File
import kotlin.collections.map
import kotlin.io.readLines
import kotlin.text.split
import kotlin.text.toDouble


@Service
class JardinService(private val repository: JardinRepository) {

    fun listarJardines(): List<Jardin> = repository.findAll()

    fun buscarPorId(id: Int): Jardin? = repository.findById(id).orElse(null)

    fun guardar(jardin: Jardin): Jardin = repository.save(jardin)

    fun borrar(id: Int) {
        if (repository.existsById(id)) {
            repository.deleteById(id)
        }
    }


    fun importarDesdeCSV() {

        // 1. Verificar si ya hay datos para no duplicar (opcional)
        //if (repository.count() > 0) return

        // 2. Leer el fichero (Lógica del Ejemplo 3)
        val filePath = "src/main/resources/data/Jardins.csv"
        val file = File(filePath)

        if (file.exists()) {
            println("el fichero existe")
            val JardinsLeidas = file.readLines().map { linea ->
                val partes = linea.split(";")
                // 3. Crear el objeto Jardin (Lógica del Ejemplo 4)
                // IMPORTANTE: Ponemos id_Jardin = null para que se genere uno nuevo
                Jardin(
                    id_jardin = null,
                    nombre = partes[1],
                    ubicacion = partes[2]
                )
            }
            // 4. Guardar todo en la BD de golpe
            repository.saveAll(JardinsLeidas)
        }
    }
}
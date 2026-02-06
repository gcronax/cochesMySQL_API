package com.example.cochesMySQL.controller.restControllers

import com.example.cochesMySQL.model.Depreciacion
import com.example.cochesMySQL.service.DepreciacionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/deprecations")
class DepreciacionController(
    private val depreciacionService: DepreciacionService
) {

    @GetMapping
    fun listarTodas(): List<Depreciacion> {
        return depreciacionService.listarTodas()
    }

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Int): Depreciacion? {
        return depreciacionService.obtenerPorId(id)
    }

    @GetMapping("/car/{id}")
    fun obtenerPorFk(@PathVariable id: Int):  Depreciacion? = depreciacionService.obtenerPorFk(id)

}
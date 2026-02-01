package com.example.cochesMySQL.controller

import com.example.cochesMySQL.service.ConcesionarioCocheService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

// Clase auxiliar para capturar los datos del formulario
class ConcesionarioCocheForm(
    var idConcesionario: Int = 0,
    var idCoche: Int = 0,
    var cantidad: Int = 0
)

@Controller
class ConcesionarioCocheController(
    private val concesionarioCocheService: ConcesionarioCocheService
) {

    @GetMapping("/cc")
    fun listaConcesionariosCoches(model: Model): String {
        val relaciones = concesionarioCocheService.listarTodas()
        model.addAttribute("relaciones", relaciones)
        return "cc"
    }

    // Mostrar el formulario (GET)
    @GetMapping("/cc/add")
    fun mostrarFormulario(model: Model): String {
        model.addAttribute("form", ConcesionarioCocheForm())
        model.addAttribute("concesionarios", concesionarioCocheService.listarConcesionarios())
        model.addAttribute("coches", concesionarioCocheService.listarCoches())
        return "ccForm" // Nombre del archivo HTML del formulario
    }

    // Procesar el formulario (POST)
    @PostMapping("/cc/guardar")
    fun guardarRelacion(@ModelAttribute("form") form: ConcesionarioCocheForm): String {
        concesionarioCocheService.guardar(form.idConcesionario, form.idCoche, form.cantidad)
        return "redirect:/cc" // Redirige a la lista principal
    }
}

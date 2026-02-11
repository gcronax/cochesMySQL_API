package com.example.cochesMySQL.controller

import com.example.cochesMySQL.service.ConcesionarioCocheService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

// Clase auxiliar para capturar los datos del formulario
class ConcesionarioCocheForm(
    var idConcesionario: Int = 0,
    var idCoche: Int = 0,
    var precio: Int = 0
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

    @GetMapping("/cc/add")
    fun mostrarFormulario(model: Model): String {
        model.addAttribute("form", ConcesionarioCocheForm())
        model.addAttribute("concesionarios", concesionarioCocheService.listarConcesionarios())
        model.addAttribute("coches", concesionarioCocheService.listarCoches())
        return "ccForm"
    }

    @PostMapping("/cc/guardar")
    fun guardarRelacion(@ModelAttribute("form") form: ConcesionarioCocheForm): String {
        concesionarioCocheService.guardar(form.idConcesionario, form.idCoche, form.precio)
        return "redirect:/cc"
    }

    @GetMapping("/cc/coches-por-concesionario")
    fun formularioCochesPorConcesionario(model: Model): String {
        model.addAttribute("concesionarios", concesionarioCocheService.listarConcesionarios())
        return "cochesPorConcesionarioForm"
    }

    @PostMapping("/cc/coches-por-concesionario")
    fun mostrarCochesDeConcesionario(
        @RequestParam idConcesionario: Int,
        model: Model
    ): String {

        val relaciones = concesionarioCocheService.obtenerCochesDeConcesionario(idConcesionario)
        model.addAttribute("relaciones", relaciones)
        model.addAttribute("concesionarios", concesionarioCocheService.listarConcesionarios())
        model.addAttribute("idConcesionarioSeleccionado", idConcesionario)

        return "cochesPorConcesionarioForm"
    }



}

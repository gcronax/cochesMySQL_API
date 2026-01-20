package com.example.plantasMySQL.controller
import com.example.plantasMySQL.model.Planta
import com.example.plantasMySQL.service.PlantaService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class PlantaController(private val plantaService: PlantaService) {

    @GetMapping("/plantas")
    fun listar(model: Model): String {
        model.addAttribute("plantas", plantaService.listarPlantas())
        return "plantas"
    }

    @GetMapping("/planta/{id_planta}")
    fun detalle(@PathVariable id_planta: Int, model: Model): String {
        val planta = plantaService.buscarPorId(id_planta) ?: return "errorPlanta"
        model.addAttribute("planta", planta)
        return "detallePlanta"
    }

    @GetMapping("/plantas/nueva")
    fun nuevaPlanta(model: Model): String {
        val plantaVacia = Planta(nombre = "", tipo = "", altura = 0.0, foto = "")
        model.addAttribute("planta", plantaVacia)
        model.addAttribute("titulo", "Nueva Planta")
        return "formularioPlanta"
    }

    @GetMapping("/plantas/editar/{id_planta}")
    fun editarPlanta(@PathVariable id_planta: Int, model: Model): String {
        val planta = plantaService.buscarPorId(id_planta) ?: return "redirect:/plantas"
        model.addAttribute("planta", planta)
        model.addAttribute("titulo", "Editar Planta")
        return "formularioPlanta"
    }

    @PostMapping("/plantas/guardar")
    fun guardarPlanta(@ModelAttribute planta: Planta): String {
        plantaService.guardar(planta)
        return "redirect:/plantas"
    }

    @GetMapping("/plantas/borrar/{id_planta}")
    fun borrarPlanta(@PathVariable id_planta: Int): String {
        plantaService.borrar(id_planta)
        return "redirect:/plantas"
    }


    // 1. Ruta para mostrar la página de inicio (index.html)
    @GetMapping("/")
    fun inicio(): String {
        return "index"
    }



    // 2. Ruta para ejecutar la importación
    @GetMapping("/importar")
    fun importarDatos(): String {
        plantaService.importarDesdeCSV() // <--- Tienes que crear este método en el Service como hablamos antes
        return "redirect:/plantas" // Al terminar, nos lleva a la lista para ver el resultado
    }


}
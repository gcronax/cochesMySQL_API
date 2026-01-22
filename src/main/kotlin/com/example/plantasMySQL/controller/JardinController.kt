package com.example.plantasMySQL.controller
import com.example.plantasMySQL.model.Jardin
import com.example.plantasMySQL.service.JardinService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class JardinController(private val jardinService: JardinService) {

    @GetMapping("/jardines")
    fun listar(model: Model): String {
        model.addAttribute("jardines", jardinService.listarJardines())
        return "jardines"
    }

    @GetMapping("/jardin/{id_jardin}")
    fun detalle(@PathVariable id_jardin: Int, model: Model): String {
        val jardin = jardinService.buscarPorId(id_jardin) ?: return "errorjardin"
        model.addAttribute("jardin", jardin)
        return "jardinesDetalles"
    }

    @GetMapping("/jardines/nueva")
    fun nuevajardin(model: Model): String {
        val jardinVacia = Jardin(nombre = "", ubicacion = "")
        model.addAttribute("jardin", jardinVacia)
        model.addAttribute("titulo", "Nuevo jardin")
        return "formularioJardin"
    }

    @GetMapping("/jardines/editar/{id_jardin}")
    fun editarjardin(@PathVariable id_jardin: Int, model: Model): String {
        val jardin = jardinService.buscarPorId(id_jardin) ?: return "redirect:/jardines"
        model.addAttribute("jardin", jardin)
        model.addAttribute("titulo", "Editar jardin")
        return "formularioJardin"
    }

    @PostMapping("/jardines/guardar")
    fun guardarjardin(@ModelAttribute jardin: Jardin): String {
        jardinService.guardar(jardin)
        return "redirect:/jardines"
    }

    @GetMapping("/jardines/borrar/{id_jardin}")
    fun borrarjardin(@PathVariable id_jardin: Int): String {
        jardinService.borrar(id_jardin)
        return "redirect:/jardines"
    }









}
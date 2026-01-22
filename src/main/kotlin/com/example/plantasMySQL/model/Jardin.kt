package com.example.plantasMySQL.model
import jakarta.persistence.*

@Entity
@Table(name = "jardines")
data class Jardin(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id_jardin: Int? = null,

    @Column(nullable = false)
    var nombre: String = "",

    @Column
    var ubicacion: String = ""


)
package com.example.plantasMySQL.model
import jakarta.persistence.*

@Entity
@Table(name = "plantas")
data class Planta(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id_planta: Int? = null,

    @Column(nullable = false)
    var nombre: String = "",

    @Column
    var tipo: String = "",

    @Column
    var altura: Double = 0.0,

    @Column
    var foto: String = ""
)
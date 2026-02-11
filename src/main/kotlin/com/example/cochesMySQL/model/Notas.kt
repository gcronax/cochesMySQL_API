package com.example.cochesMySQL.model

import jakarta.persistence.*

@Entity
@Table(name = "notas")
data class Nota(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    var id_nota: Int? = null,

    @Column(name = "coche_fk")
    var cocheFk: Int? = null,

    @Column(nullable = false)
    var texto: String? = null
)
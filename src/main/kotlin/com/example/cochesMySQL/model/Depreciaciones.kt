package com.example.cochesMySQL.model

import com.example.cochesMySQL.converter.ListToJsonConverter
import jakarta.persistence.*

@Entity
@Table(name = "depreciaciones")
data class Depreciacion(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_depreciacion")
    var id_depreciacion: Int? = null,

    @Column(name = "coche_fk")
    var cocheFk: Int? = null,

    @Column(name = "valores", columnDefinition = "json")
    @Convert(converter = ListToJsonConverter::class)
    var valores: MutableList<Int> = mutableListOf()
)
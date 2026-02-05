package com.example.cochesMySQL.model
import jakarta.persistence.*

@Embeddable
class ConcesionarioCocheId(
    var id_concesionario: Int = 0,
    var id_coche: Int = 0
)

@Entity
class ConcesionarioCoche(

    @EmbeddedId
    var id: ConcesionarioCocheId = ConcesionarioCocheId(),

    @ManyToOne
    @MapsId("id_coche")
    @JoinColumn(name = "id_coche")
    var coche: Coche? = null,

    @ManyToOne
    @MapsId("id_concesionario")
    @JoinColumn(name = "id_concesionario")
    var concesionario: Concesionario? = null,

    @Column(nullable = false)
    var precio: Int = 0
)
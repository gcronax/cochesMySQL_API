package com.example.plantasMySQL.repository

import com.example.plantasMySQL.model.Planta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlantaRepository : JpaRepository<Planta, Int>
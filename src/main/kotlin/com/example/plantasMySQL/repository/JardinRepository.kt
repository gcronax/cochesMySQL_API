package com.example.plantasMySQL.repository

import com.example.plantasMySQL.model.Jardin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JardinRepository : JpaRepository<Jardin, Int>
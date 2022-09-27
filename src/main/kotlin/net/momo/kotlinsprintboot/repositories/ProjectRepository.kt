package net.momo.kotlinsprintboot.repositories

import net.momo.kotlinsprintboot.domain.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository: JpaRepository<Project, String> {
    fun findByNameContains(name: String): List<Project>
}
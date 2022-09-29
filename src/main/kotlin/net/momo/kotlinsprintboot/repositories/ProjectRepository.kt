package net.momo.kotlinsprintboot.repositories

import net.momo.kotlinsprintboot.domain.Project
import net.momo.kotlinsprintboot.domain.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import javax.annotation.PostConstruct

interface ProjectRepository: PagingAndSortingRepository<Project, String> {
    fun findByNameContains(name: String): List<Project>
}
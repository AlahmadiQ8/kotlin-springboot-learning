package net.momo.kotlinsprintboot.services

import net.momo.kotlinsprintboot.domain.Project
import net.momo.kotlinsprintboot.repositories.ProjectRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ProjectService(val db: ProjectRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun getAll(): List<Project> {
        logger.info("Getting all projects")
        return db.findAll().toList()
    }

    fun findByNameContains(name: String): List<Project> {
        return db.findByNameContains(name)
    }

    fun save(project: ProjectDTO): Project {
        val newProject = Project(name = project.name)

        return db.save(newProject)
    }
}

data class ProjectDTO(val name: String)
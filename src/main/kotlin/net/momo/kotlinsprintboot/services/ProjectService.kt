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

    fun findById(id: String): Project? {
        return db.findById(id).orElse(null)
    }

    fun save(project: ProjectDTO): Project {
        val newProject = Project(name = project.name)

        return db.save(newProject)
    }
}

data class ProjectDTO(val name: String)
package net.momo.kotlinsprintboot.services

import net.momo.kotlinsprintboot.domain.Project
import net.momo.kotlinsprintboot.domain.Task
import net.momo.kotlinsprintboot.domain.TaskStatus
import net.momo.kotlinsprintboot.repositories.ProjectRepository
import org.jetbrains.annotations.NotNull
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.LongSummaryStatistics
import java.util.Optional
import java.util.StringJoiner
import javax.print.DocFlavor.STRING
import javax.validation.constraints.NotBlank

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

    fun findById(id: Long): Optional<Project> {
        return db.findById(id)
    }

    fun save(project: ProjectDTO): Project {
        val newProject = Project(name = project.name)
        newProject.tasks = project.tasks?.map {
            Task(
                name = it.name,
                description = "description for task ${it.name}",
                taskStatus = TaskStatus.values().random()
            )
        }?.toMutableList() ?: mutableListOf()

        return db.save(newProject)
    }
}

data class ProjectDTO(
    @NotBlank
    val name: String,

    val tasks: List<TaskDTO>?
    )
data class TaskDTO(val name: String)
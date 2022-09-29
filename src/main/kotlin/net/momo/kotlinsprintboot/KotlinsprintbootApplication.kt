package net.momo.kotlinsprintboot

import net.momo.kotlinsprintboot.domain.Message
import net.momo.kotlinsprintboot.domain.Project
import net.momo.kotlinsprintboot.domain.Task
import net.momo.kotlinsprintboot.repositories.ProjectRepository
import net.momo.kotlinsprintboot.services.MessageService
import net.momo.kotlinsprintboot.services.ProjectDTO
import net.momo.kotlinsprintboot.services.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import javax.annotation.PostConstruct

@SpringBootApplication
class KotlinsprintbootApplication {

    @Autowired
    lateinit var projectRepository: ProjectRepository

    @PostConstruct
    fun postConstruct() {
        projectRepository.save(
            Project(
                name = "Project 1",
                tasks = mutableListOf(Task(name = "Task 1"),Task(name = "Task 2"), )
            )
        )
        projectRepository.save(
            Project(
                name = "Project 2",
                tasks = mutableListOf(Task(name = "Task 1"),Task(name = "Task 2"), )
            )
        )
        projectRepository.save(
            Project(
                name = "Project 3",
                tasks = mutableListOf(Task(name = "Task 1"),Task(name = "Task 2"), )
            )
        )
    }
}

fun main(args: Array<String>) {
    runApplication<KotlinsprintbootApplication>(*args)
}

@RestController
class MessageResource(val service: MessageService) {
    @GetMapping
    fun index(): List<Message> = service.findMessages()

    @PostMapping
    fun post(@RequestBody message: Message) {
        service.post(message)
    }
}

@RestController
@RequestMapping("/api/projects")
class ProjectResource(val service: ProjectService) {
    @GetMapping()
    fun getAll(@RequestParam name: String?): List<Project> {
        if (name != null) {
            return service.findByNameContains(name)
        }

        return service.getAll()
    }

    @PostMapping
    fun post(@RequestBody project: ProjectDTO) {
        service.save(project)
    }
}
package net.momo.kotlinsprintboot

import net.momo.kotlinsprintboot.domain.Message
import net.momo.kotlinsprintboot.domain.Project
import net.momo.kotlinsprintboot.domain.Task
import net.momo.kotlinsprintboot.repositories.ProjectRepository
import net.momo.kotlinsprintboot.services.MessageService
import net.momo.kotlinsprintboot.services.ProjectDTO
import net.momo.kotlinsprintboot.services.ProjectService
import org.apache.juli.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.StringJoiner
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

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Project {
        return service.findById(id).get()
//            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
    }

    @PostMapping
    fun post(@RequestBody project: ProjectDTO) {
        service.save(project)
    }
}

@Controller
@RequestMapping("/projects")
class ProjectController(val service: ProjectService) {

    @GetMapping
    fun getProjects(model: Model): String {
        val projects = service.getAll().map { it.name?.let { it1 -> ProjectDTO(it1, mutableListOf()) } }
        model.addAttribute("projects", projects)
        return "projects"
    }
}
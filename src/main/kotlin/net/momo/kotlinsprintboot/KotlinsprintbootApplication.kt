package net.momo.kotlinsprintboot

import net.momo.kotlinsprintboot.domain.Message
import net.momo.kotlinsprintboot.domain.Project
import net.momo.kotlinsprintboot.services.MessageService
import net.momo.kotlinsprintboot.services.ProjectDTO
import net.momo.kotlinsprintboot.services.ProjectService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class KotlinsprintbootApplication

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
    fun getAll(): List<Project> = service.getAll()

    @PostMapping
    fun post(@RequestBody project: ProjectDTO) {
        service.save(project)
    }
}
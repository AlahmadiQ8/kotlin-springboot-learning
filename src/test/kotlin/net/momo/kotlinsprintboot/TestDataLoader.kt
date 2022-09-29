package net.momo.kotlinsprintboot

import net.momo.kotlinsprintboot.domain.Project
import net.momo.kotlinsprintboot.repositories.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component
import java.time.LocalDate


@Component
class TestDataLoader(@Autowired val projectRepository: ProjectRepository) : ApplicationContextAware {

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        projectRepository.save(Project("Project one", LocalDate.now()))
        projectRepository.save(Project("Project two", LocalDate.now()))
        projectRepository.save(Project("Project three", LocalDate.now()))
        projectRepository.save(Project("Project four", LocalDate.now()))
    }
}
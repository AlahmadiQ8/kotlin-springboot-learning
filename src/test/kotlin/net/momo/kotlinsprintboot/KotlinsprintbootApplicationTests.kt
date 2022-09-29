package net.momo.kotlinsprintboot

import net.momo.kotlinsprintboot.services.ProjectDTO
import net.momo.kotlinsprintboot.services.ProjectService
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import java.time.LocalDate

@SpringBootTest
class KotlinsprintbootApplicationTests(@Autowired val projectService: ProjectService) {

    @Test
    fun contextLoads() {
    }

    @Test
    fun savingProjectsWorks() {
        val savedProject = projectService.save(ProjectDTO("test project", tasks = mutableListOf()))

        assert(savedProject != null)
    }
}

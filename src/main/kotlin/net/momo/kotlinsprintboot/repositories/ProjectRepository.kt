package net.momo.kotlinsprintboot.repositories

import net.momo.kotlinsprintboot.domain.Project
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface ProjectRepository: CrudRepository<Project, String> {
}
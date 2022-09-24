package net.momo.kotlinsprintboot.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import java.util.StringJoiner

@Table("projects")
data class Project(
    @Id @Column("id") val id: String? = null,
    @Column("name") val name: String,
    @Column("date_created") val dateCreated: LocalDate = LocalDate.now())
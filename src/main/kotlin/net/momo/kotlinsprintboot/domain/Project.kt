package net.momo.kotlinsprintboot.domain

import java.time.LocalDate
import javax.persistence.*

@Table(name = "projects", indexes = [
    Index(name = "idx_project_name", columnList = "name")
])
@Entity
class Project(
    @Column(name = "name")
    var name: String,

    @Column(name = "date_created")
    var dateCreated: LocalDate = LocalDate.now(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: String? = null) {

    constructor() : this("") {

    }
}

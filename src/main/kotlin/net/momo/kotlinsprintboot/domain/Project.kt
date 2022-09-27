package net.momo.kotlinsprintboot.domain

import java.time.LocalDate
import javax.persistence.*


@Table(name = "projects", indexes = [
    Index(name = "idx_project_name", columnList = "name")
])
@Entity
class Project(
    @Column(name = "name", nullable = false)
    var name: String? = "",

    @Column(name = "date_created")
    var dateCreated: LocalDate? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: String? = null,

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    open var tasks: MutableList<Task> = mutableListOf()
)

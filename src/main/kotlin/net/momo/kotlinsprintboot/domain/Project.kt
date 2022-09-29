package net.momo.kotlinsprintboot.domain

import org.hibernate.criterion.AggregateProjection
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
    var id: Long? = null,

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    var tasks: MutableList<Task> = mutableListOf()
)

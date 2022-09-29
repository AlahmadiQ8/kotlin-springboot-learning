package net.momo.kotlinsprintboot.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "task")
open class Task (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null,

    @Column(name = "name", nullable = false)
    open var name: String = "",

    @Column(name = "description")
    open var description: String? = null,


    @Column(name = "date_created", nullable = false)
    open var dateCreated: LocalDate? = LocalDate.now(),

    @Column(name = "due_date", nullable = true)
    open var dueDate: LocalDate? = null,

    @Enumerated
    @Column(name = "task_status", nullable = false)
    open var taskStatus: TaskStatus? = TaskStatus.NEW,

    @ManyToOne
    @JoinColumn(name = "project_id")
    open var project: Project? = null,
    )

enum class TaskStatus { NEW, IN_PROGRESS, COMPLETE }
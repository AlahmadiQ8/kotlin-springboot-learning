package net.momo.kotlinsprintboot.domain

import javax.persistence.*

@Table(name = "messages")
@Entity
class Message(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    var id: Long? = null,

    @Column(name = "text") val text: String = "",
)
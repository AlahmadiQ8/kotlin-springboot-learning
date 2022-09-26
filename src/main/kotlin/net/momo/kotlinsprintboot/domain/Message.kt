package net.momo.kotlinsprintboot.domain

import javax.persistence.*

@Table(name = "messages")
@Entity
class Message(
    @Column(name = "text") val text: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    var id: String? = null,
) {
    constructor() : this("") {

    }
}
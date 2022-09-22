package net.momo.kotlinsprintboot.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("messages")
data class Message(@Id val id: String?, @Column("text") val text: String)
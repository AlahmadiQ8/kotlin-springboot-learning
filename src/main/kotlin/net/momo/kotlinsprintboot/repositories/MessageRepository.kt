package net.momo.kotlinsprintboot.repositories

import net.momo.kotlinsprintboot.domain.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface MessageRepository : JpaRepository<Message, String> {

    @Query("select m from Message m")
    fun findMessages(): List<Message>
}
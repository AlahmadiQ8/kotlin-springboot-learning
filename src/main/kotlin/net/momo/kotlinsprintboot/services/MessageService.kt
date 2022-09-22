package net.momo.kotlinsprintboot.services

import net.momo.kotlinsprintboot.domain.Message
import net.momo.kotlinsprintboot.repositories.MessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService(val db: MessageRepository) {

    fun findMessages(): List<Message> = db.findMessages()

    fun post(message: Message){
        db.save(message)
    }
}
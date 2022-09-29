package net.momo.kotlinsprintboot.errors

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(EmptyResultDataAccessException::class, NoSuchElementException::class)
    fun handleEmptyResultDataAccessException(ex: Exception): ResponseEntity<String> {
        return ResponseEntity("Exception retrieving data: ${ex.message}", HttpStatus.NOT_FOUND)
    }
}
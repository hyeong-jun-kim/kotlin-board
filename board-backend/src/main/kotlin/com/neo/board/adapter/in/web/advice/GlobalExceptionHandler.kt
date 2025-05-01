package com.neo.board.adapter.`in`.web.advice

import com.neo.board.common.dto.ErrorResponse
import com.neo.board.common.dto.FieldError
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.Instant

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun onValidationError(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val fieldErrors = ex.bindingResult.fieldErrors.map {
            FieldError(it.field, it.defaultMessage ?: "Invalid value")
        }
        val body = ErrorResponse(
            timestamp = Instant.now().toString(),
            status = 400,
            code = "VALIDATION_FAILED",
            message = "입력값이 올바르지 않습니다.",
            fieldErrors = fieldErrors
        )
        return ResponseEntity.badRequest().body(body)
    }
}
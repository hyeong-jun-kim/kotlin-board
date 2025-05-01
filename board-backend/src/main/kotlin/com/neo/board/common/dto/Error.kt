package com.neo.board.common.dto

data class ErrorResponse(
    val timestamp: String,
    val status: Int,
    val code: String,
    val message: String,
    val fieldErrors: List<FieldError>? = null
)

data class FieldError(
    val field: String,
    val message: String
)
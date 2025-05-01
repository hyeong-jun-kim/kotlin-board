package com.neo.board.application.port.`in`.user.dto

data class UpdateUserCommand(
    val id: Long,
    val name: String,
    val email: String
)

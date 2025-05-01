package com.neo.board.application.port.`in`.user.dto

data class CreateUserCommand(
    val name: String,
    val email: String
)
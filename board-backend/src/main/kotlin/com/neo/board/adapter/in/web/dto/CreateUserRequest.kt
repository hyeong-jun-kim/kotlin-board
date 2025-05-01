package com.neo.board.adapter.`in`.web.dto

import com.neo.board.application.port.`in`.user.dto.CreateUserCommand

data class CreateUserRequest(
    val name: String,
    val email: String
) {
    fun toCommand(): CreateUserCommand {
        return CreateUserCommand(name = name, email = email)
    }
}
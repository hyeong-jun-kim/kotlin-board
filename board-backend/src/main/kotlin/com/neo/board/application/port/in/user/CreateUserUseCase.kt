package com.neo.board.application.port.`in`.user

import com.neo.board.application.port.`in`.user.dto.CreateUserCommand

interface CreateUserUseCase {
    fun createUser(command: CreateUserCommand): Long
}
package com.neo.board.application.port.`in`.user

import com.neo.board.application.port.`in`.user.dto.UpdateUserCommand

interface UpdateUserUseCase {
    fun updateUser(command: UpdateUserCommand)
}
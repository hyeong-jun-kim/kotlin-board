package com.neo.board.application.port.`in`.user

import com.neo.board.application.port.`in`.user.dto.GetUserQuery
import com.neo.board.application.port.`in`.user.dto.UserDto

interface GetUserUseCase {
    fun getUser(query: GetUserQuery): UserDto
}
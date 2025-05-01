package com.neo.board.application.service

import com.neo.board.application.port.`in`.user.dto.CreateUserCommand
import com.neo.board.application.port.`in`.user.CreateUserUseCase
import com.neo.board.application.port.`in`.user.DeleteUserUseCase
import com.neo.board.application.port.`in`.user.GetUserUseCase
import com.neo.board.application.port.`in`.user.UpdateUserUseCase
import com.neo.board.application.port.`in`.user.dto.GetUserQuery
import com.neo.board.application.port.`in`.user.dto.UpdateUserCommand
import com.neo.board.application.port.`in`.user.dto.UserDto
import com.neo.board.domain.model.entity.User
import com.neo.board.domain.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserApplicationService(
    private val userRepository: UserRepository
) : CreateUserUseCase, GetUserUseCase, UpdateUserUseCase, DeleteUserUseCase {
    companion object {
        const val SUCCESS: Long = 1
    }

    @Transactional
    override fun createUser(command: CreateUserCommand): Long {
        val user = User(name = command.name, email = command.email)
        return userRepository.save(user)
    }

    override fun getUser(query: GetUserQuery): UserDto {
        val dto = userRepository.findById(query.id)
            ?: throw IllegalArgumentException("User not found with id: ${query.id}")
        return UserDto(id = dto.id!!, name = dto.name, email = dto.email)
    }

    @Transactional
    override fun updateUser(command: UpdateUserCommand) {
        val userId = userRepository.findById(command.id)
            ?: throw IllegalArgumentException("User not found with id: ${command.id}")
        val updatedUser = User(id = userId.id, name = command.name, email = command.email)

        val row = userRepository.update(updatedUser)
        if (row != SUCCESS) {
            throw IllegalStateException("Failed to update user with id: ${command.id}")
        }
    }

    @Transactional
    override fun deleteUser(userId: Long) {
        val row = userRepository.deleteById(userId)
        if (row != SUCCESS) {
            throw IllegalStateException("Failed to delete user with id: $userId")
        }
    }
}
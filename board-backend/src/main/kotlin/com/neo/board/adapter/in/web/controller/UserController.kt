package com.neo.board.adapter.`in`.web.controller

import com.neo.board.adapter.`in`.web.dto.CreateUserRequest
import com.neo.board.adapter.`in`.web.dto.UpdateUserRequest
import com.neo.board.adapter.`in`.web.dto.UserResponse
import com.neo.board.application.port.`in`.user.CreateUserUseCase
import com.neo.board.application.port.`in`.user.DeleteUserUseCase
import com.neo.board.application.port.`in`.user.GetUserUseCase
import com.neo.board.application.port.`in`.user.UpdateUserUseCase
import com.neo.board.application.port.`in`.user.dto.GetUserQuery
import com.neo.board.application.port.`in`.user.dto.UpdateUserCommand
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val createUserUserCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody request: CreateUserRequest): UserResponse {
        val id = createUserUserCase.createUser(request.toCommand())
        return UserResponse(id, request.name, request.email);
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): UserResponse {
        val dto = getUserUseCase.getUser(GetUserQuery(id))
        return UserResponse(dto.id, dto.name, dto.email)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateUser(@PathVariable id: Long, @RequestBody request: UpdateUserRequest) {
        val command = UpdateUserCommand(id, request.name, request.email)
        updateUserUseCase.updateUser(command)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Long) {
        deleteUserUseCase.deleteUser(id)
    }
}
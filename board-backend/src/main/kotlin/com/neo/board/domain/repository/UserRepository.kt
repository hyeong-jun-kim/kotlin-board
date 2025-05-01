package com.neo.board.domain.repository

import com.neo.board.domain.model.entity.User

interface UserRepository {
    fun save(user: User): Long

    fun findById(id: Long): User?

    fun update(user: User): Long

    fun deleteById(id: Long): Long
}